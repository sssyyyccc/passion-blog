package com.developerchen.blog.module.site.web;

import com.developerchen.blog.constant.BlogConst;
import com.developerchen.blog.module.comment.domain.entity.Comment;
import com.developerchen.blog.module.comment.service.ICommentService;
import com.developerchen.blog.module.post.domain.entity.Post;
import com.developerchen.blog.module.post.service.IPostService;
import com.developerchen.blog.module.site.domain.dto.StatisticsDTO;
import com.developerchen.blog.module.site.domain.dto.ThemeDTO;
import com.developerchen.blog.module.site.service.ISiteService;
import com.developerchen.blog.theme.Common;
import com.developerchen.core.config.AppConfig;
import com.developerchen.core.domain.RestResponse;
import com.developerchen.core.exception.RestException;
import com.developerchen.core.web.BaseController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 站点后台管理
 *
 * @author syc
 */
@Controller
@RequestMapping("/admin")
public class SiteAdminController extends BaseController {

    private final ISiteService siteService;
    private final IPostService postService;
    private final ICommentService commentService;

    public SiteAdminController(ISiteService siteService,
                               IPostService postService,
                               ICommentService commentService) {
        this.siteService = siteService;
        this.postService = postService;
        this.commentService = commentService;
    }

    /**
     * 获取最近评论, 随机文章及后台统计数据
     */
    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
        List<Comment> commentList = commentService.recentComments(BlogConst.COMMENT_RECENT_SIZE);
        List<Post> postList = postService.getPostList(BlogConst.POST_RANDOM, BlogConst.POST_RANDOM_SIZE);
        StatisticsDTO statistics = siteService.getStatistics();

        model.addAttribute("commentList", commentList);
        model.addAttribute("postList", postList);
        model.addAttribute("statistics", statistics);
        return "admin/index";
    }

    /**
     * 获取主题的参数设置
     */
    @GetMapping("/theme/setting")
    public String getThemeSetting(Model model) {
        model.addAllAttributes(AppConfig.OPTIONS);
        return "themes/" + Common.blogTheme() + "/setting";
    }

    /**
     * 获取所有主题
     */
    @ResponseBody
    @GetMapping("/api/themes")
    public RestResponse getThemes() {
        List<ThemeDTO> themeList = new ArrayList<>(6);
        try {
            File themes = new ClassPathResource("templates/themes").getFile();
            File[] themesFile = themes.listFiles();
            if (themesFile != null) {
                for (File file : themesFile) {
                    if (file.isDirectory()) {
                        ThemeDTO themeDTO = new ThemeDTO(file.getName());
                        if (Files.exists(Paths.get(file.getPath()).resolve("setting.html"))) {
                            themeDTO.setHasSetting(true);
                        }
                        themeList.add(themeDTO);
                    }
                }
            }
        } catch (IOException e) {
            throw new RestException("获取主题文件失败", e);
        }
        return RestResponse.ok(themeList);
    }

    /**
     * 激活指定主题
     */
    @ResponseBody
    @PostMapping("/api/themes/active")
    public RestResponse activeTheme(@RequestBody Map<String, String> parameterMap) {
        String themeName = parameterMap.get("themeName");
        siteService.activeTheme(themeName);
        return RestResponse.ok();
    }

    /**
     * 设置主题参数
     */
    @ResponseBody
    @PostMapping("/api/theme/setting")
    public RestResponse saveThemeSetting(@RequestParam Map<String, String> parameterMap) {
        siteService.saveThemeSetting(parameterMap);
        return RestResponse.ok();
    }

    /**
     * 站点参数设置
     */
    @ResponseBody
    @PostMapping("/api/site/setting")
    public RestResponse saveSiteSetting(@RequestParam Map<String, String> parameterMap) {
        siteService.saveSiteSetting(parameterMap);
        return RestResponse.ok();
    }

    /**
     * 获取所有配置项
     */
    @ResponseBody
    @GetMapping("/api/options")
    public RestResponse getOptions() {
        return RestResponse.ok(AppConfig.OPTIONS);
    }

}
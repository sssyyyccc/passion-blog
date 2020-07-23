(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-29ea551c"],{"278d":function(t,e,o){"use strict";o.r(e);var n=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"setting"},[o("el-card",{staticStyle:{height:"100%"},attrs:{"body-style":{padding:"16px 0",height:"100%"}},scopedSlots:t._u([{key:"header",fn:function(){return[o("span",[t._v("网站设置")])]},proxy:!0}])},[o("div",{staticClass:"setting-content"},[o("el-row",{attrs:{gutter:16}},[o("el-col",{attrs:{lg:8,md:24}},[o("el-form",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],ref:"optionsForm",attrs:{"label-position":"top",model:t.options,"status-icon":"",rules:t.optionRules}},[o("el-form-item",{attrs:{label:"网站域名",prop:"hostname"}},[o("el-input",{attrs:{placeholder:"域名"},scopedSlots:t._u([{key:"prepend",fn:function(){return[o("el-select",{staticClass:"scheme-select",attrs:{placeholder:"请选择"},model:{value:t.options.scheme,callback:function(e){t.$set(t.options,"scheme",e)},expression:"options.scheme"}},[o("el-option",{attrs:{label:"http://",value:"http"}}),o("el-option",{attrs:{label:"https://",value:"https"}})],1)]},proxy:!0}]),model:{value:t.options.hostname,callback:function(e){t.$set(t.options,"hostname",e)},expression:"options.hostname"}}),o("span",[o("small",[t._v("请和你当前访问的域名保持一致，否则会出现渲染错误。")])])],1),o("el-form-item",{attrs:{label:"博客标题",prop:"blog_title"}},[o("el-input",{attrs:{placeholder:"博客标题"},model:{value:t.options.blog_title,callback:function(e){t.$set(t.options,"blog_title",e)},expression:"options.blog_title"}})],1),o("el-form-item",{attrs:{label:"博客关键字",prop:"blog_keywords"}},[o("el-input",{attrs:{type:"textarea",placeholder:"seo",autosize:{minRows:2},maxlength:"500"},model:{value:t.options.blog_keywords,callback:function(e){t.$set(t.options,"blog_keywords",e)},expression:"options.blog_keywords"}})],1),o("el-form-item",{attrs:{label:"博客描述",prop:"blog_description"}},[o("el-input",{attrs:{type:"textarea",placeholder:"博客描述",autosize:{minRows:4},maxlength:"500","show-word-limit":""},model:{value:t.options.blog_description,callback:function(e){t.$set(t.options,"blog_description",e)},expression:"options.blog_description"}})],1),o("el-form-item",{attrs:{label:"评论是否需要审批"}},[o("el-switch",{attrs:{"active-value":t.systemConst.YES,"inactive-value":t.systemConst.NO,"active-text":"需要","inactive-text":"不需要"},model:{value:t.options.allow_comment_approve,callback:function(e){t.$set(t.options,"allow_comment_approve",e)},expression:"options.allow_comment_approve"}})],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.submitForm("optionsForm")}}},[t._v(" 保存设置 ")])],1)],1)],1)],1)],1)])],1)},s=[],i=(o("4160"),o("7039"),o("b64b"),o("159b"),o("b775")),a="/admin",l={getOptions:function(){return Object(i["a"])({url:"".concat(a,"/options"),method:"get"})},updateOptions:function(t){return Object(i["a"])({url:"".concat(a,"/options"),method:"post",data:t})}},r=l,c={name:"Setting",data:function(){var t=this,e={max:500,trigger:"blur",message:"长度不能超过 500 个字符"},o=function(e,o,n){""===t.options.scheme?n(new Error("请选择Http协议")):""===o||""===t.options.scheme?n(new Error("请输入网站域名")):n()};return{options:{scheme:"",hostname:"",blog_title:"",blog_keywords:"",blog_description:"",allow_comment_approve:"0"},oldOptions:{},optionRules:{hostname:[e,{validator:o,trigger:["blur","change"]}],blog_title:[e],blog_keywords:[e],blog_description:[e]},loading:!1}},mounted:function(){this.getOptions()},methods:{getOptions:function(){var t=this;this.loading=!0,r.getOptions().then((function(e){Object.assign(t.oldOptions,e.data),Object.keys(e.data).forEach((function(o){t.$set(t.options,o,e.data[o])})),t.loading=!1})).catch((function(e){console.dir(e),t.$confirm("获取网站设置数据失败, 是否重新获取?","错误",{confirmButtonText:"确定",cancelButtonText:"取消",type:"error"}).then((function(){t.getOptions()})).catch((function(){t.loading=!1}))}))},updateOptions:function(){var t=this,e=this.diffOptions(this.options,this.oldOptions);0!==Object.getOwnPropertyNames(e).length?r.updateOptions(e).then((function(){t.$message.info("保存成功"),t.loading=!1})).catch((function(){t.$message.error("保存失败, 请重新保存"),t.loading=!1})):this.$message.info("没有任何配置被修改过, 无需保存")},submitForm:function(t){var e=this;this.$refs[t].validate((function(t){return!!t&&(e.updateOptions(),!0)}))},diffOptions:function(t,e){var o={};return Object.keys(t).forEach((function(n){var s=t[n],i=e[n];s!==i&&(o[n]=s)})),o}}},p=c,u=(o("fa08"),o("2877")),d=Object(u["a"])(p,n,s,!1,null,null,null);e["default"]=d.exports},7039:function(t,e,o){var n=o("23e7"),s=o("d039"),i=o("057f").f,a=s((function(){return!Object.getOwnPropertyNames(1)}));n({target:"Object",stat:!0,forced:a},{getOwnPropertyNames:i})},c0cc:function(t,e,o){t.exports={primaryColor:"#3298dc",menuTextColor:"rgba(255,255,255,.65)",menuActiveTextColor:"#3298dc",menuBackgroundColor:"#324157",sidebarWidth:"210px",sidebarCollapsedWidth:"64px",headerHeight:"64px"}},fa08:function(t,e,o){"use strict";var n=o("c0cc"),s=o.n(n);s.a}}]);
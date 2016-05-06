package com.personas.common;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by YNzF on 2016/4/21.
 */
public class HtmlUtils {
    /**
     * 将带有html代码的字符串过滤掉其中的html代码
     * @param inputString
     * @return
     */
    public static String Html2Text(String inputString) {
        String htmlStr = inputString; //含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); //过滤html标签

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;//返回文本字符串
    }


    public static String unEscapHtml(String html) {
        if(StringUtils.isBlank(html)) return html;
        return StringEscapeUtils.unescapeHtml(html);
    }

    public static String removeDuplicateBlankSpace(String html) {
        if(html == null) return html;
        return html.replaceAll("\\s{2,}", " ");
    }

    public static void main(String[] args) {
        String html = "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>华人富豪千万美元买房，与新西兰总理做邻居&nbsp;--&nbsp;并读新闻</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"Cache-Control\" content=\"no-transform\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\">\n" +
                "    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
                "    <meta name=\"appl e-mobile-web-app-status-bar-style\" content=\"black\">\n" +
                "    <meta name=\"format-detection\" content=\"telephone=no\">\n" +
                "    <meta name=\"description\" content=\"据新西兰天维网援引NZ Herald消息报道，近日，新西兰华人土豪再次出手，以1010万的价格购买了位于Parnell的一座无敌海景豪宅。\">\n" +
                "        <link rel=\"stylesheet\" href=\"http://bingodu.oeeee.com/css/main.css\" type=\"text/css\">\n" +
                "    <!--[if lt IE 9]>\n" +
                "    <script>\n" +
                "        (function() {\n" +
                "            if (!/*@cc_on!@*/0) return;\n" +
                "            var e = \"abbr, article, aside, audio, canvas, datalist, details, dialog, eventsource, figure, footer, header, hgroup, mark, menu, meter, nav, output, progress, section, time, video\".split(', ');\n" +
                "            var i= e.length;\n" +
                "            while (i--){\n" +
                "                document.createElement(e[i])\n" +
                "            }\n" +
                "        })()\n" +
                "    </script>\n" +
                "    <style>\n" +
                "        body{font-size:100%;background:#eee;}\n" +
                "        .news-containner,.footer-banner{width:760px;margin:0 auto;background:#fff;font-size:14px;}\n" +
                "        .news-cont .bd{display:block;padding:0 3%;zoom:1;}\n" +
                "        .footer-banner{background:#000;filter:Alpha(opacity=80);}\n" +
                "        .footer-banner *{position:relative;}\n" +
                "        .download-btn,#J_download_btn{font-size:14px;}\n" +
                "    </style>\n" +
                "    <![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div class=\"news-containner\">\n" +
                "    <article class=\"news-cont\" role=\"main\">\n" +
                "        <div class=\"download-banner\" id=\"dl_banner\">\n" +
                "            <div class=\"app\">\n" +
                "                <i class=\"app-icon\"><img src=\"http://bingodu.oeeee.com/css/app_icon.png\" alt=\"并读新闻app\"></i>\n" +
                "                <p class=\"app-info\"><span><em>并读新闻</em></span></p>\n" +
                "            </div>\n" +
                "            <div class=\"download\">\n" +
                "                <a href=\"javascript:void(0);\" class=\"download-btn\" target=\"_blank\">下载Android版</a>\n" +
                "                <a href=\"javascript:void(0);\" class=\"download-btn\" target=\"_blank\">下载iPhone版</a>\n" +
                "                <a href=\"http://m.bingodu.com/\" class=\"download-btn\" target=\"_blank\">进入触屏版</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <header class=\"hd\">\n" +
                "            <h2 class=\"title\">华人富豪千万美元买房，与新西兰总理做邻居</h2>\n" +
                "            <p class=\"news-info\">\n" +
                "                <time>2015-11-16 15:17:06</time>\n" +
                "                <span>网易财经</span>\n" +
                "            </p>\n" +
                "            <p class=\"news-info2\" id=\"J_news_info\">\n" +
                "                <span class=\"view l\"><i class=\"icon icon-view\"></i><b class=\"view-num\" id=\"view_num\">0</b></span>\n" +
                "                <span class=\"praise l\"><i class=\"icon icon-praise\"></i><b class=\"praise-num\" id=\"praise_num\">0</b></span>\n" +
                "                <span class=\"comment l\"><i class=\"icon icon-comment\"></i><b class=\"comment-num\" id=\"comment_num\">0</b></span>\n" +
                "            </p>\n" +
                "        </header>\n" +
                "        <section class=\"bd\" id=\"J_cont\">\n" +
                "            <p></p> \n" +
                "<center> \n" +
                " <p><img src=\"http://image.bingodu.com/default/default_pic.png?t=20151014\" _src=\"http://image.bingodu.com/group1/M01/49/4B/CgELI1ZJgvKAdmVIAABsTkAdISg10.jpeg\" data-src=\"http://image.bingodu.com/group1/M01/49/4B/CgELI1ZJgvKAdmVIAABsTkAdISg10.jpeg\" data-url=\"http://image.bingodu.com/group1/M01/49/4B/CgELI1ZJgvKAdmVIAABsTkAdISg10.jpeg\" data-origin-height=\"192\" data-origin-width=\"453\"></p> \n" +
                "</center> \n" +
                "<p></p> \n" +
                "<p>据新西兰天维网援引NZ Herald消息报道，近日，新西兰华人土豪再次出手，以1010万的价格购买了位于Parnell的一座无敌海景豪宅。</p> \n" +
                "<p></p> \n" +
                "<center> \n" +
                " <p><img src=\"http://image.bingodu.com/default/default_pic.png?t=20151014\" _src=\"http://image.bingodu.com/group1/M04/49/4B/CgELI1ZJgvOAGEN5AAEpGTqQXFQ34.jpeg\" data-src=\"http://image.bingodu.com/group1/M04/49/4B/CgELI1ZJgvOAGEN5AAEpGTqQXFQ34.jpeg\" data-url=\"http://image.bingodu.com/group1/M04/49/4B/CgELI1ZJgvOAGEN5AAEpGTqQXFQ34.jpeg\" data-origin-height=\"396\" data-origin-width=\"613\"></p> \n" +
                "</center> \n" +
                "<p></p> \n" +
                "<center> \n" +
                " <p><img src=\"http://image.bingodu.com/default/default_pic.png?t=20151014\" _src=\"http://image.bingodu.com/group1/M02/49/4B/CgELI1ZJgvSAbhQHAAFC6v5xEm027.jpeg\" data-src=\"http://image.bingodu.com/group1/M02/49/4B/CgELI1ZJgvSAbhQHAAFC6v5xEm027.jpeg\" data-url=\"http://image.bingodu.com/group1/M02/49/4B/CgELI1ZJgvSAbhQHAAFC6v5xEm027.jpeg\" data-origin-height=\"406\" data-origin-width=\"613\"></p> \n" +
                "</center> \n" +
                "<p></p> \n" +
                "<p>该房产原主人是汽车经销商Bob McMillan和妻子Kerry，由Graham Wall房地产公司负责出售。房产经纪Ollie和Andrew Wall介绍，该物业面积450平方米，拥有超大车库、温控酒窖、加热泳池、露天桑拿、每层都有直达电梯等等，还带有一个面朝城市的办公室，而且每个房间都坐拥无敌景致。</p> \n" +
                "<p></p> \n" +
                "<center> \n" +
                " <p><img src=\"http://image.bingodu.com/default/default_pic.png?t=20151014\" _src=\"http://image.bingodu.com/group1/M00/49/4B/CgELI1ZJgvWAMZJbAADIXW2W1_M68.jpeg\" data-src=\"http://image.bingodu.com/group1/M00/49/4B/CgELI1ZJgvWAMZJbAADIXW2W1_M68.jpeg\" data-url=\"http://image.bingodu.com/group1/M00/49/4B/CgELI1ZJgvWAMZJbAADIXW2W1_M68.jpeg\" data-origin-height=\"470\" data-origin-width=\"381\"></p> \n" +
                "</center> \n" +
                "<p></p> \n" +
                "<center> \n" +
                " <p><img src=\"http://image.bingodu.com/default/default_pic.png?t=20151014\" _src=\"http://image.bingodu.com/group1/M03/49/4B/CgELI1ZJgvaAWxB8AADzrWUTLNY22.jpeg\" data-src=\"http://image.bingodu.com/group1/M03/49/4B/CgELI1ZJgvaAWxB8AADzrWUTLNY22.jpeg\" data-url=\"http://image.bingodu.com/group1/M03/49/4B/CgELI1ZJgvaAWxB8AADzrWUTLNY22.jpeg\" data-origin-height=\"407\" data-origin-width=\"612\"></p> \n" +
                "</center> \n" +
                "<p></p> \n" +
                "<p>该房产的价值约为920万刀，中介Walls表示，由于新西兰元走低，海外买家对奥克兰房产的兴趣不断升温，“房子最终卖给了一个中国家庭，”他们说。</p> \n" +
                "<p>这座位于St Stephens Ave的房产其实是与总理John Key家在同一条街上，“海外买家十分热衷，”Graham Wall表示，“而且，由于纽币汇率的原因，国际买家对奥克兰的豪宅十分感兴趣，我们最近一直在忙于许多美国富豪的需求，但其实奥克兰根本提供不了足够的完美房产。”</p> \n" +
                "<p>据悉，原房主Mcmillan夫妇之前是Team McMillan BMW成员，这所位于St Stephens Ave的豪宅是他们自己建造的。</p>\n" +
                "        </section>\n" +
                "        <div class=\"top-read\" id=\"J_top_read\">\n" +
                "            <h3 class=\"hd\"><span class=\"l\"><i class=\"l icon-line\"></i>并友热读</span>\n" +
                "            </h3>\n" +
                "            <div class=\"bd\">\n" +
                "                <ul class=\"top-read-list\" id=\"J_list\">\n" +
                "                    <li><a href=\"http://bingodu.com/\"></a></li>\n" +
                "                    <li><a href=\"http://bingodu.com/\"></a></li>\n" +
                "                    <li><a href=\"http://bingodu.com/\"></a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </article>\n" +
                "</div>\n" +
                "<div class=\"page-bottom\" id=\"page_bottom\"></div>\n" +
                "</body>\n" +
                "<script language=\"javascript\" src=\"http://bingodu.oeeee.com/js/main.js?t=20150908\"></script>";

        String result = HtmlUtils.Html2Text(html);
        System.out.println("-----------------------------------");
        System.out.println(removeDuplicateBlankSpace(unEscapHtml(result)));
    }
}

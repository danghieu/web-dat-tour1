/**
* Encouraged Commentary - A comment traverser to help manage conversations on web pages.
* Copyright (c) 2009 Jim Jeffers - jim(at)donttrustthisguy(dot)com | http://donttrustthisguy.com
* Dual licensed under MIT and GPL.
* Date: 1/09/2009
* @author Jim Jeffers
* @version 1.0
*
* Intro Article:
* http://donttrustthisguy.com/2009/01/04/encouraged-commentary/ 
*
* Source:
* http://github.com/jimjeffers/encouraged-commentary/tree/master
*/
jQuery(document).ready(function(){jQuery(document.body).append("<span id=\"comment-respond\">Quote This</span>");var j=jQuery('#comment-respond');j.css('position','absolute');j.fadeTo(10,0);var k="";var l="";var m="";jQuery('.commentlist > .comment, .quotable').each(function(){jQuery(this).mouseup(function(e){j.css('top',e.pageY+10);j.css('left',e.pageX+10);if(getSelText()){j.show();j.fadeTo("normal",10);var a=findCommentFor(e.target);if(a){k=findPermalinkFor(a).href;l=findAuthorFor(a).text}else{k=false;l=false}m=getSelText()}})});j.hover(function(){jQuery(this).fadeTo("fast",1)},function(){jQuery(this).fadeTo("fast",0.3)});j.mousedown(function(e){var a="";if(k&&l){a="<p><a href=\""+k+"\">@"+l+"</a>:</p>\n"}jQuery('#comment').val(a+"<blockquote>"+m+"</blockquote>\n\n");jQuery.scrollTo('#commentform',{duration:1000});jQuery(this).fadeTo(1,0);j.hide()});jQuery(document.body).mousedown(function(){j.hide()});jQuery('.commentlist .comment a').click(function(e){var a=getAnchor(this.href);if(jQuery('.commentlist '+a).length>0){setCurrentComment(a);jQuery.scrollTo(a,{duration:1000});return false}});var n=jQuery(jQuery('.commentlist').get(0));var o=new Array();var p=new Array();var q=n.hasClass('sorted-commentary');jQuery('.commentlist .comment p:first-child a:first-child').each(function(){if(this.text.substring(1,-1)=="@"){var a=this.text.substring(1,this.text.length);var b=findCommentFor(this);var c=findAuthorFor(b);var d=findPermalinkFor(b);var e=getAnchor(this.href);var f='<a href="'+d.href+'">'+c.innerHTML+'</a>';var g=jQuery('.commentlist #'+e.substr(1,e.length));if(g.length>0&&q){jQuery(g.get(0)).after(b.addClass('response'))}if(!p[e]){p[e]=new Array(f)}else{p[e][p[e].length]=f}}});var r='';if(!n.hasClass('no-quote-control')){r+='<a href="#" class="comment-quote">Quote</a>'}if(!n.hasClass('no-reply-control')){r+='<a href="#" class="comment-reply">Reply</a>'}jQuery('.commentlist > .comment').each(function(){var c=findAuthorFor(this);var d=findPermalinkFor(this);var f=getAnchor(d.href);var g='<a href="'+d.href+'">'+d.innerHTML+'</a>';if(!o[c.text]){o[c.text]=new Array(g)}else{o[c.text][o[c.text].length]=g}jQuery(this).append('<div class="comment-controls">'+r+'</div>');jQuery(this).find('.comment-reply, .comment-quote').each(function(){if(jQuery(this).hasClass('comment-reply')){jQuery(this).click(function(e){setupComment(this,false);return false})}if(jQuery(this).hasClass('comment-quote')){jQuery(this).click(function(e){setupComment(this,true);return false})}});var h=false;var i=jQuery(jQuery(this).find('.comment-controls'));i.hide();jQuery(this).hover(function(){if(o[c.text].length>1||p[f]){if(jQuery(this).find('div.comment-controls div.related-replies, div.comment-controls div.related-comments').length<1){if(p[f]&&!n.hasClass('no-replies')){var b="";(p[f].length>1)?b="replies":b="reply";i.append('<div class="related-replies"><h6>'+(p[f].length)+' '+b+' to this comment</h6><ol>'+printReplies(p[f])+'</ol></div>')}if(o[c.text].length>1&&!n.hasClass('no-relatives')){var b="";(o[c.text].length-1>1)?b="comments":b="comment";i.append('<div class="related-comments"><h6>'+(o[c.text].length-1)+' other '+b+' from '+c.text+'</h6><ol>'+printRelatives(o[c.text],g)+'</ol></div>')}jQuery(this).find('div.comment-controls ol li a').click(function(e){var a=getAnchor(this.href);setCurrentComment(a);jQuery.scrollTo(a,{duration:1000});return false})}}if(!i.is(':visible')&&!h){h=setTimeout(function(){i.fadeIn("fast");h=false},300)}else{clearTimeout(h);h=false}},function(){if(!i.is(':visible')&&h){clearTimeout(h);h=false}else if(i.is(':visible')&&!h){h=setTimeout(function(){i.fadeOut("fast");h=false},500)}})})});function findCommentFor(a){a=jQuery(a);while(!a.hasClass('comment')){if(a.hasClass('quotable')){return false}a=jQuery(a.parent())}return a};function findPermalinkFor(a){return jQuery(a).find('.comment-permalink').get(0)};function findAuthorFor(a){return jQuery(a).find('.comment-author-name').get(0)};function printRelatives(a,b){var c="";var d="";for(var i=0;i<=a.length-1;i++){(a[i]==b)?d="current":d="";c+='<li class="'+d+'">'+a[i]+'</li>'};return c};function printReplies(a){var b="";for(var i=0;i<=a.length-1;i++){b+='<li>'+a[i]+'</li>'};return b};function setCurrentComment(a){jQuery('.commentlist .current-comment').removeClass('current-comment');jQuery(jQuery('.commentlist '+a).get(0)).addClass('current-comment')};function getAnchor(a){return'#'+a.split("#")[1]};function setupComment(b,c){var d=findCommentFor(b);var e='<p><a href="'+findPermalinkFor(d).href+'">@'+findAuthorFor(d).text+'</a></p>';if(c){c="<blockquote>";if(d.find('.entry-content > p').length>0){d.find('.entry-content > p').each(function(){var a=false;if(jQuery(this).find("a:first-child").length>0){if(jQuery(this).find("a:first-child").get(0).text.substring(1,-1)=="@"){a=true}}if(!a){c+="<p>"+this.innerHTML+"</p>"}})}else{c=d.innerHTML}c+="</blockquote>";c=c.replace("\n<!-- Start your comment below this line. -->\n\n","");c=c.replace("\n<!-- Start your comment below this line. -->\n","");c=c.replace("<!-- Start your comment below this line. -->","")}else{c=""}jQuery('#comment').val(e+c+"\n<p>\n<!-- Start your comment below this line. -->\n\n</p>");jQuery.scrollTo('#comment',{duration:1000})};function getSelText(){var a='';if(window.getSelection){a=window.getSelection()}else if(document.getSelection){a=document.getSelection()}else if(document.selection){a=document.selection.createRange().text}else return;if(String(a).length>2){a=String(a).replace(/\n\n/g,"</p><p>").replace(/\n/g,"<br/>");return"<p>"+a+"</p>"}else{return false}};
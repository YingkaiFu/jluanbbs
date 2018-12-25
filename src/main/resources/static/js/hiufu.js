
    //在页面加载完后立即执行多个函数。
    function addloadEvent(func){
        var oldonload=window.onload;
        if(typeof window.onload !="function"){
            window.onload=func;
        }
        else{
            window.onload=function(){
                if(oldonload){
                    oldonload();
                }
                func();
            }
        }
    }
addloadEvent(b);
function b(){
    var pn=document.getElementById("pn");
    var lists=pn.children;
    //删除当前节点
    function remove(node){
        node.parentNode.removeChild(node);
    }
    //上面的点赞
    function praisebox(box,el){
        //获取赞数量容器
        var praise=box.getElementsByClassName("people")[0];
        //获取容器当前total值
        var total=parseInt(praise.getAttribute("total"));
        //获取点击的innerHTML
        var txt=el.innerHTML;
        //创建一个新的total存储用
        var newtotal;
        //判断点击的文字内容
        if(txt=="赞"){
            //total值+1 因为我还没点击赞，所以要点击的时候就多了一个人 total+1
            newtotal=total+1;
            //判断赞数量 把相应文字放到赞容器里
            praise.innerHTML=newtotal==1 ? "我觉得很赞" : "我和" + total +"个人觉得很赞";
            el.innerHTML="取消赞";
        }
        else{
            //反之total值-1
            newtotal=total-1;
            praise.innerHTML=newtotal==0 ? "" : newtotal +"个人觉得很赞";
            el.innerHTML="赞";
        }
        //更新total值
        praise.setAttribute("total",newtotal);
        //如果没有人点赞容器隐藏
        praise.style.display=(newtotal==0) ? "none" : "block";
    }
    //回复评论
    function reply(box){
        //获取评论框
        var textarea=box.getElementsByTagName("textarea")[0];
        //获取包含所有评论的容器
        var comment=box.getElementsByClassName("comment-list")[0];
        //创建新的评论div
        var div=document.createElement("div");
        //赋类名
        div.className="comment";
        //设置属性
        div.setAttribute("user","self");
        //获取每条评论的innerHTML结构，每次只替换textarea的输入内容和 当前发送时间
        var html='<div class="comment-left">'+'<img src="images/T2.jpg" alt=""/>'+'</div>'+
            '<div class="comment-right">'+
            '<div class="comment-text"><span>我：</span>'+textarea.value+'</div>'+
            '<div class="comment-date">'+
            getTime()+
            '<a class="comment-zan" href="javascript:;" total="0" my="0">赞</a>'+
            '<a class="comment-dele" href="javascript:;">删除</a>'+
            '</div>'+
            '</div>';
        //插入到新建的评论div
        div.innerHTML=html;
        //把新评论插入到评论列表
        comment.appendChild(div);
        //评论后初始化textarea输入框
        textarea.value="评论…";
        textarea.parentNode.className="hf";
    }
    //获取当前时间回复评论时调用
    function getTime(){
        var t=new Date();
        var y=t.getFullYear();
        var m=t.getMonth()+1;
        var d=t.getDate();
        var h=t.getHours();
        var mi=t.getMinutes();
        m=m<10?"0"+m:m;
        d=d<10?"0"+d:d;
        h=h<10?"0"+h:h;
        mi=mi<10?"0"+mi:mi;
        return y+"-"+m+"-"+d+""+h+":"+mi;
    }
    //回复里点赞
    function praiseReply(el){
        //获取当前total值 也就是所有点赞数量
        var total=parseInt(el.getAttribute("total"));
        //获取当前my值 我的点赞
        var my=parseInt(el.getAttribute("my"));
        //创建新的total
        var newtotal;
        //判断my=0就是我准备要点赞
        if(my==0){
            //我点了赞总数量就要+1
            newtotal=total+1;
            //更新total值
            el.setAttribute("total",newtotal);
            //更新my值
            el.setAttribute("my",1);
            //更新文字 就是我点了后 文字就是取消赞了
            el.innerHTML=newtotal+" 取消赞";
        }else{
            //反之-1
            newtotal=total-1;
            el.setAttribute("total",newtotal);
            el.setAttribute("my",0);
            el.innerHTML=(newtotal==0)?" 赞":newtotal+" 赞";
        }
    }
    //操作回复
    function operateReply(el){
        //每条评论
        var comment=el.parentNode.parentNode.parentNode;
        //整个状态
        var box=comment.parentNode.parentNode.parentNode;
        //评论框
        var textarea=box.getElementsByTagName("textarea")[0];
        //名字
        var user=comment.getElementsByClassName("user")[0];
        //点击的innerHTML
        var txt=el.innerHTML;
        //判断当前点击的是否为回复
        if(txt=="回复"){
            //评论框触发焦点事件 也就是变高
            textarea.onfocus();
            //内容变为回复+当前人的名字
            textarea.value="回复 "+user.innerHTML;
            //调用键盘事件
            textarea.onkeyup();
        }else{
            //否则就是删除节点
            remove(comment);
        }
    }
    //遍历所有状态消息
    for(var i=0;i<lists.length;i++){
        //全部事件代理
        lists[i].onclick=function(e){
            //获取当前点击事件
            var e=e||window.event;
            var el=e.srcElement;
            if(!el){
                el=e.target;//兼容火狐
            }
            //判断点击的类名
            switch(el.className){
                //关闭整个状态
                case "close":
                    remove(el.parentNode);
                    break;
                //上面的点赞
                case "dzan":
                    praisebox(el.parentNode.parentNode.parentNode,el);
                    break;
                //回复评论
                case "hf-btn hf-btn-on":
                    reply(el.parentNode.parentNode.parentNode);
                    break;
                //每条评论中点赞
                case "comment-zan":
                    praiseReply(el);
                    break;
                case "comment-dele":
                    operateReply(el);
                    break;
            }
        }
        var textarea=lists[i].getElementsByClassName("hf-text")[0];
        //焦点事件
        textarea.onfocus=function(){
            this.parentNode.className='hf hf-on';
            this.value = this.value == '评论…' ? '' : this.value;
        }
        //失焦事件
        textarea.onblur=function(){
            if(this.value==''){
                this.parentNode.className='hf';
                this.value ='评论…';
            }
        }
        //键盘事件
        textarea.onkeyup=function(){
            var len=this.value.length;
            var textParentNode=this.parentNode;
            var textBtn=textParentNode.children[1];
            var textNub=textParentNode.children[2];
            if(len==0 /*|| len>100*/){
                textBtn.className="hf-btn";
            }else{
                textBtn.className="hf-btn hf-btn-on";
                /*this.style.color="#333"; */
            }
            textNub.innerHTML=len+"/100";
        }
    }
    //遍历结束
}

/**
 * Created by 姓唐名静梅 on 2016/9/1 0001.
 */
$(function(){


    $(".detailed-introduction").click(function(){
        $("#article4").css("display","block").siblings().css("display","none");
    });

    $(".all").click(function(){
        $("#article6").css("display","block").siblings().css("display","none");
    });



//logo
    $("#logo").click(function(){
        window.location.href="Index.jsp";
    });


//middle的左右滑动效果
    $(function(){
        var arr=new Array(2);
        arr[0]=0;
        arr[1]=0;

        var containerHeight=$("#middle").height();

        var a=null;
        var b=null;
        var c=null;

        $(".main #nav li").hover(function (){
            var index=$(this).index();

            // alert(index)
            arr.push(index+1);
            arr.shift();


            var middleHeight=$(".middle-1").eq(index).height();


            var timer=setTimeout(function (){
                $("#middle").animate({height:middleHeight},400);

            },400);
            $(".middle-1").eq(index).fadeIn();
            // alert($("#middle").height())

            //middle-1的动画效果

            if ( arr[1]<arr[0]  || arr[0]==0) {
                $(".middle-1").eq(index).css("top",-middleHeight);
                a=setTimeout(function(){
                    $(".middle-1").eq(index).css("z-index",index+2).siblings().css("z-index",0);
                    $(".middle-1").eq(arr[0]-1).css("z-index",1);
                    $(".middle-1").eq(index).animate({top:0},400);
                },400)

            }else if ((arr[0]>arr[1] && arr[0] - arr[1] != 0) || arr[0]==arr[1]-1 || arr[0]<arr[1]-1) {

                a=setTimeout(function(){
                    $(".middle-1").eq(index).css("top",middleHeight);
                    $(".middle-1").eq(index).css("z-index",index+2).siblings().css("z-index",0);
                    $(".middle-1").eq(arr[0]-1).css("z-index",1);
                    $(".middle-1").eq(index).animate({top:0},500);
                },800)


           }else{
                $(".middle-1").eq(index).show().siblings().hide();
            }

        },function(){

            var index=$(this).index();

            b=setTimeout(function(){
                $(".middle-1").eq(index).fadeIn(500)
            },1000)


        })


        //给.clear加上事件

        $("#middle").mouseleave(function(){
            // $("#middle").animate({height:0},400);


        });

        // 给middle-1加上事件
        $(".middle-1").hover(function(){
            clearTimeout(a);
            clearTimeout(b);
        },function(){
            // c=setTimeout(function(){
            //     $("#middle").animate({height:0},400);
            // })

        });
        $(".img, .top").mouseenter(function(){
            $("#middle").animate({height:0},400);
            arr[1]=$(".main .clear li").size();
            arr[0]=0;
        })


    });
});
$(function(){
    $(".close").click(function(){
        $(".advertise").css("display","none");
    });
});

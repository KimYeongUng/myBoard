<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@ include file="../include/head.jsp"%>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">

    <%@ include file="../include/main_header.jsp"%>
    <%@ include file="../include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Title: ${post.title}</h3>
                </div>
                <div class="box-body" style="height: 700px">
                    ${post.content}
                </div>
                <div class="box-footer">
                    <div class="user-block">
                        <img class="img-circle img-bordered-sm" src="../../../resources/dist/img/user1-128x128.jpg" alt="user image">
                        <span class="username">
                            <a href="#">${post.writer}</a>
                        </span>
                        <span class="description"><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${post.regDate}"/></span>
                    </div>
                </div>
            </div>
            <div class="box-footer">
                <form role="form" method="post">
                    <input type="hidden" name="postNo" value="${post.postNo}">
                    <input type="hidden" name="page" value="${cri.page}">
                    <input type="hidden" name="perPageNum" value="${cri.perPageNum}">
                    <input type="hidden" name="searchType" value="${cri.searchType}">
                    <input type="hidden" name="keyword" value="${cri.keyword}">
                </form>
                <button type="submit" class="btn btn-primary listBtn"><i class="fa fa-list"></i> List</button>
                <div class="pull-right">
                    <button type="submit" class="btn btn-warning modBtn"><i class="fa fa-edit"></i> Modify</button>
                    <button type="submit" class="btn btn-warning delBtn"><i class="fa fa-trash"></i> Delete</button>
                </div>
            </div>
            <div class="box box-warning">
                <div class="box-header with-border">
                    <a class="link-black text-lg"><i class="fa fa-pencil"></i> Reply</a>
                </div>
                <div class="box-body">
                    <form class="form-horizontal">
                        <div class="form-group margin">
                            <div class="col-sm-10">
                                <textarea class="form-control" id="newReplyText" rows="3" placeholder="Reply.." style="resize: none"></textarea>
                            </div>
                            <div class="col-sm-2">
                                <input class="form-control" id="newReplyWriter" type="text" placeholder="Writer..">
                            </div>
                            <hr/>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-primary btn-block replyAddBtn"><i class="fa fa-save"></i> Save</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="box box-success collapsed-box">
                <div class="box-header with-border">
                    <a href="" class="link-black text-lg"><i class="fa fa-comment-o margin-r-5 replyCount"></i></a>
                    <div class="box-tools">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse">
                            <i class="fa fa-plus"></i>
                        </button>
                    </div>
                </div>
                <div class="box-body repliesDiv">

                </div>
                <div class="box-footer">
                    <div class="text-center">
                        <ul class="pagination pagination-sm no-margin">

                        </ul>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">Modify Reply</h4>
                        </div>
                        <div class="modal-body" data-rno>
                            <input type="hidden" class="replyNo"/>
                            <textarea class="form-control" id="replyText" rows="3" style="resize: none"></textarea>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default pull-left" data-dismiss="modal"> Close</button>
                            <button type="button" class="btn btn-primary modalModBtn"> Modify</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="delModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">Delete Reply</h4>
                            <input type="hidden" class="rno"/>
                        </div>
                        <div class="modal-body" data-rno>
                            <p>Delete Reply: Are you Sure?</p>
                            <input type="hidden" class="rno"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default pull-left" data-dismiss="modal">No.</button>
                            <button type="button" class="btn btn-primary modalDelBtn">Yes.</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <%@include file="../include/main_footer.jsp"%>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane active" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:;">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:;">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<%@ include file="../include/plugin.jsp"%>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
<script>
    $(document).ready(function () {
        var formObj = $("form[role='form']");
        console.log(formObj);

        $(".modBtn").on("click",function () {
            formObj.attr("action","/post/modify");
            formObj.attr("method","get");
            formObj.submit();
        });

        $(".delBtn").on("click",function () {
            formObj.attr("action","/post/remove");
            formObj.submit();
        });

        $(".listBtn").on("click",function () {
            formObj.attr("action","/post/listCriteria");
            formObj.attr("method","get");
            formObj.submit();
        });

    });
</script>
<script id="replyTemplate" type="text/x-handlebars-template">
    {{#each.}}
    <div class="post replyDiv" data-replyNo={{replyNo}}>
        <div class="user-block">
            <img class="img-circle img-bordered-sm" src="../../../resources/dist/img/user4-128x128.jpg" alt="user image">
            <span class="username">
                <a href="#">{{replyWriter}}</a>
                <a href="#" class="pull-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal">
                    <i class="fa fa-edit"> Modify</i>
                </a>
            </span>
            <span class="description">{{prettifyDate regDate}}</span>
        </div>
        <div class="oldReplyText">{{escape replyText}}</div>
        <br/>
    </div>
    {{/each}}
</script>
<script>
    $(document).ready(function () {
        var postNo = ${post.postNo};
        var replyPageNum = 1;

        Handlebars.registerHelper("escape",function (replyText) {
            var text = Handlebars.Utils.escapeExpression(replyText);
            text = text.replace(/(\r\n|\n|\r)/gm, "<br/>");
            text = text.replace(/( )/gm, "&nbsp;");
            return new Handlebars.SafeString(text);
        });

        Handlebars.registerHelper("prettifyDate", function (timeVale) {
            var dateObj = new Date(timeVale);
            var year = dateObj.getFullYear();
            var month = dateObj.getMonth() + 1;
            var date = dateObj.getDate();
            var hours = dateObj.getHours();
            var minutes = dateObj.getMinutes();
            // 2자리 숫자 맞추기
            month < 10 ? month = '0' + month : month;
            date < 10 ? date = '0' + date : date;
            hours < 10 ? hours = '0' + hours : hours;
            minutes < 10 ? minutes = '0' + minutes : minutes;
            return year + "-" + month + "-" + date + " " + hours + ":" + minutes;
        });

        getReplies("/replies/"+postNo+"/"+replyPageNum);

        function getReplies(repliesUri) {
            $.getJSON(repliesUri,function (data) {
                printReplyCount(data.pageMaker.totalCount);
                printReplies(data.replies,$(".replyDiv"),$("#replyTemplate"));
                printReplyPaging(data.pageMaker,$(".pagination"));
            });
        }

        function printReplies(replyArr,target,templateObj) {
            var replyTemplate = Handlebars.compile(templateObj.html());
            var html = replyTemplate(replyArr);
            $(".replyDiv").remove();
            target.html(html);
        }

        function printReplyCount(totalCount) {
            var replyCount = $(".replyCount");
            var collapsedBox = $(".collapsed-box");

            if(totalCount === 0){
                replyCount.html("No Replies...");
                collapsedBox.find(".btn-box-tool").remove();
                return;
            }

            $(".replyCount").html(" 댓글목록 ("+totalCount+")");
            $(".collapsed-box").find(".box-tools").html(
                "<button type='button' class='btn btn-box-tool' data-widget='collapse'>"
                + "<i class='fa fa-plus'></i>"
                + "</button>");
        }

        function printReplyPaging(pageMaker,target) {
            var str="";
            if (pageMaker.prev) {
                str += "<li><a href='" + (pageMaker.startPage - 1) + "'>Prev</a></li>";
            }
            for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
                var strClass = pageMaker.cri.page == i ? "class=active" : "";
                str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
            }
            if (pageMaker.next) {
                str += "<li><a href='" + (pageMaker.endPage + 1) + "'>Next</a></li>"
            }
            target.html(str);
        }

        $(".pagination").on("click","li a",function (event) {
            event.preventDefault();
            replyPageNum = $(this).attr("href");
            getReplies("/replies/"+postNo+"/"+replyPageNum);
        });

        $(".replyAddBtn").on("click",function () {

            var replyWriterObj = $("#newReplyWriter");
            var replyTextObj = $("#newReplyText");
            var replyWriter = replyWriterObj.val();
            var replyText = replyTextObj.val();


            $.ajax({
            type: "post",
            url: "/replies/",
            headers: {
                "Content-Type" : "application/json",
                "X-HTTP-Method-Override" : "POST"
            },
            dataType: "text",
            data: JSON.stringify({
                postNo:postNo,
                replyWriter:replyWriter,
                replyText:replyText
            }),
            success: function (result) {
                console.log("result : " + result);
                if (result === "regSuccess") {
                    alert("Reply Registered.");
                    replyPageNum = 1;  // 페이지 1로 초기화
                    getReplies("/replies/all/" + postNo + "/" + replyPageNum); // 댓글 목록 호출
                    replyTextObj.val("");     // 작성자 입력창 공백처리
                    replyWriterObj.val("");   // 댓글 입력창 공백처리
                }
            }
            });
        });

        $(".repliesDiv").on("click",".replyDiv",function (event) {
            var reply = $(this);
            $(".replyNo").val(reply.attr("data-replyNo"));
            $("#replyText").val(reply.find(".oldReplyText")).text();
        });

        $(".modalModBtn").on("click",function () {
            var replyNo = $(".replyNo").val();
            var replyText = $("#replyText").val();
            $.ajax({
                type:"put",
                url:"/replies/"+replyNo,
                headers:{
                    "Content-Type":"application/json",
                    "X-HTTP-Method-Override": "PUT"
                },
                dataType:"text",
                data:JSON.stringify({
                    replyText: replyText
                }),
                success:function(result){
                    console.log("result: "+result);
                    if(result === "modSuccess"){
                        alert("Modify Completed");
                        getReplies("/replies/"+postNo+"/"+replyPageNum);
                        $("#modModal").modal("hide");
                    }
                }
            });
        });

        $(".modalDelBtn").on("click",function () {
            var replyNo = $(".replyNo").val();
            $.ajax({
                type:"delete",
                url:"/replies/"+replyNo,
                headers:{
                    "Content-Type":"application/json",
                    "X-HTTP-Method-Override": "DELETE"
                },
                dataType:"text",
                success:function(result){
                    console.log("result: "+result);
                    if(result === "delSuccess"){
                        alert("Delete Completed");
                        getReplies("/replies/"+postNo+"/"+replyPageNum);
                        $("#delModal").modal("hide");
                    }
                }
            });
        });
    });
</script>
</body>
</html>
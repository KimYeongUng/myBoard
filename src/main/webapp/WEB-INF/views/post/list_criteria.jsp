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
            <div class="col-lg-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title"> List</h3>
                    </div>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <th style="width: 30px">#</th>
                                <th> Post</th>
                                <th style="width: 100px"> Writer</th>
                                <th style="width: 150px"> Time</th>
                                <th style="width: 60px"> View</th>
                            </tr>
                            <c:forEach items="${posts}" var="post">
                                <tr>
                                    <td>${post.postNo}</td>
                                    <td><a href="${path}/post/read${pageMaker.makeSearch(pageMaker.cri.page)}&postNo=${post.postNo}">${post.title}</a> </td>
                                    <td>${post.writer}</td>
                                    <td><fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd a HH:mm"/></td>
                                    <td><span class="badge bd-red">${post.viewCnt}</span></td >
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="box-footer">
                        <div class="text-center">
                            <ul class="pagination">
                                <c:if test="${pageMaker.prev}">
                                    <li><a href="${path}/post/listCriteria${pageMaker.makeSearch(pageMaker.startPage-1)}">Prev</a> </li>
                                </c:if>
                                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                                    <li <c:out value="${pageMaker.cri.page == idx ? 'class=active':''}"/> >
                                        <a href="${path}/post/listCriteria${pageMaker.makeSearch(idx)}">${idx}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageMaker.next && pageMaker.endPage>0}">
                                    <li><a href="${path}/post/listCriteria${pageMaker.makeSearch(pageMaker.endPage+1)}">Next</a></li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="form-group col-sm-2">
                            <select class="form-control" name="searchType" id="searchType">
                                <option value="n" <c:out value="${cri.searchType == null ? 'selected' : ''}"/>>:::::: 선택 ::::::</option>
                                <option value="t" <c:out value="${cri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
                                <option value="c" <c:out value="${cri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
                                <option value="w" <c:out value="${cri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
                                <option value="tc" <c:out value="${cri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
                                <option value="cw" <c:out value="${cri.searchType eq 'cw' ? 'selected' : ''}"/>>내용+작성자</option>
                                <option value="tcw" <c:out value="${cri.searchType eq 'tcw' ? 'selected' : ''}"/>>제목+내용+작성자</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-10">
                            <div class="input-group">
                                <input type="text" class="form-control" name="keyword" id="keywordInput" value="${cri.keyword}" placeholder="keyword">
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-primary btn-flat" id="searchBtn">
                                        <i class="fa fa-search"></i> Search
                                    </button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="pull-right">
                            <button type="button" class="btn btn-success btn-flat" id="writeBtn">
                                <i class="fa fa-pencil"></i> Write
                            </button>
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
<script>
    var result = "${msg}";
    if(result == "regSuccess")
        alert("Complete: Post Registered");
    else if(result == "modSuccess")
        alert("Complete: Modify Successed")
    else if(result == "delSuccess")
        alert("Complete: Delete Successed");

    $(document).ready(function () {
        $("#searchBtn").on("click",function (event) {
            self.location=
                "/post/listCriteria${pageMaker.makeQuery(1)}"
            +"&searchType="+$("select option:selected").val()
            +"&keyword="+encodeURIComponent($("#keywordInput").val());
        });
    });
</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css"/>
<link rel="stylesheet" href="${contextPath}/static/assets/css/datepicker.css"/>
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css"/>

<div class="row">
    <div class="col-xs-12">
        <a id="addRedBag" role="button" class="btn btn-info btn-sm" data-toggle="modal">
            产生幸运用户
        </a>

        <table id="grid-table"></table>

        <div id="grid-pager"></div>

        <script type="text/javascript">
            var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
        </script>

        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div>
<!-- /.row -->

<div id="modal-table" class="modal fade" tabindex="-1" data-backdrop="static">
    <div class="modal-dialog" style="min-width: 620px;">

        <form id="redBagForm" action="">
            <div class="modal-content">
                <div class="modal-header no-padding">
                    <div class="table-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <span class="white">&times;</span>
                        </button>
                        产生奥运大竞猜幸运用户
                    </div>
                </div>
                <div class="modal-body" style="max-height: 500px;overflow-y: scroll;">
                    <div class="blue clearfix">
                        <label for="count">中国队金牌数：</label>
                        <input type="text" id="count" name="count" class="width-100"/>
                        <%-- <input type="hidden" id="count" name="count">--%>
                    </div>
                    <div class="blue clearfix">
                        <label for="count">您想产生哪天的竞猜幸运用户？</label>
                    </div>
                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="time" name="time" type="date" class="form-control"
                                   placeholder=""/>
                            <i class="ace-icon fa fa-clock-o"></i>
                        </span>
                    </label>

                </div>

                <div class="modal-footer no-margin-top">
                    <div class="text-center">
                        <button id="submitButton" type="submit" class="btn btn-app btn-success btn-xs">
                            <i class="ace-icon fa fa-floppy-o bigger-160"></i>
                            保存
                        </button>
                        <button class="btn btn-app btn-pink btn-xs" data-dismiss="modal">
                            <i class="ace-icon fa fa-share bigger-160"></i>
                            取消
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js", "${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js", "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null]
    $('.page-content-area').ace_ajax('loadScripts', scripts, function () {

        // inline scripts related to this page
        jQuery(function ($) {
            var grid_selector = "#grid-table";
            var pager_selector = "#grid-pager";

            // resize to fit page size
            $(window).on('resize.jqGrid', function () {
                $(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
            })
            // resize on sidebar collapse/expand
            var parent_column = $(grid_selector).closest('[class*="col-"]');
            $(document).on('settings.ace.jqGrid', function (ev, event_name, collapsed) {
                if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
                    // setTimeout is for webkit only to give time for DOM changes and then redraw!!!
                    setTimeout(function () {
                        $(grid_selector).jqGrid('setGridWidth', parent_column.width());
                    }, 0);
                }
            })


            $("#addRedBag").bind("click", function () {
                var selectedId = $(grid_selector).jqGrid("getGridParam", "selrow");
                /*  if (null == selectedId) {
                 return;
                 }*/
                var ids = $(grid_selector).jqGrid('getGridParam', 'selarrrow'); // Get All IDs
                console.log(ids);
                $('#userIds').val(ids);
                $("#modal-table").modal("toggle");


            });
            $("#redBagForm").on("submit", function (e) {

                var count = $("#count").val();
                var time = $("#time").val();

                if(count==''){
                    alert("请填写中国金牌数！");
                    return;
                }
                if(time==''){
                    alert("请选择日期!");
                    return;
                }

                $("#modal-table").modal("toggle");

                $.ajax({
                    dataType: "json",
                    url: "${contextPath}/olympic_games/make_luck_user",
                    type: "post",
                    data: {
                        count: count,
                        time: time,
                    },
                    complete: function (xmlRequest) {
                        if (xmlRequest.responseText == "success") {

                            $.gritter.add({
                                title: "成功",
                                text: "成功！",
                                class_name: "gritter-info gritter-center",
                                time: 1000
                            });
                            jQuery(grid_selector).trigger("reloadGrid");
                        }
                    }
                });
            });


            jQuery(grid_selector).jqGrid({
                subGrid: false,
                url: "${contextPath}/olympic_games/get_luck_user",
                datatype: "json",
                height: 450,
                colNames: ['', '记录ID', '用户账号(openId)', '当日金牌竞猜数', '竞猜时间', '奖励发放状态'],
                colModel: [{
                    name: '',
                    index: '',
                    width: 80,
                    fixed: true,
                    sortable: false,
                    resize: false,
                    formatter: 'actions',
                    search: false,


                    formatoptions: {
                        keys: true,
                        //禁用行编辑按钮
                        editbutton: false,

                        delbutton: false,//disable delete button
                        delOptions: {
                            recreateForm: true,
                            beforeShowForm: beforeDeleteCallback
                        }
                        //editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
                    }
                }, {
                    name: 'id',
                    index: 'id',
                    label: '用户ID',
                    width: 60,
                    sorttype: "long",
                    search: false,
                    searchoptions: {sopt: ['eq']},
                }, {
                    name: 'openId',
                    index: 'openId',
                    label: '用户账号(openId)',
                    width: 100,
                    search: true,
                    editable: false,
                    editoptions: {size: "20", maxlength: "50"},
                    editrules: {required: true},
                    searchoptions: {
                        sopt: ["in"]
                    }
                }, {
                    name: 'count',
                    index: 'count',
                    label: '当日金牌竞猜数',
                    width: 160,
                    editable: false,
                    editoptions: {size: "20", maxlength: "30"},
                    search: false,
                    searchoptions: {sopt: ['in']},
                    editrules: {required: true}
                }, {
                    name: 'time',
                    index: 'time',
                    label: '竞猜时间',
                    width: 150,
                    search: false,
                    editable: false,

                }, {
                    name: 'state',
                    index: 'state',
                    editable: true,
                    formatter: function (cellvalue, options, rowdata) {
                        if (cellvalue == 1) {
                            return '已发放';
                        } else {
                            return '未发放';
                        }
                    },
                    label: '奖励发放状态',
                    width: 100,
                    edittype: "select",
                    editoptions: {value: "0:未发放;1:已发放"},
                    search: false
                }],
                //scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
                sortname: "time",
                sortorder: "desc",
                viewrecords: true,
                rowNum: 10,
                rowList: [10, 20, 100, 500, 2000],
                pager: pager_selector,
                altRows: true,
                //toppager : true,
                multiselect: true,
                //multikey : "ctrlKey",
                multiboxonly: true,
                loadComplete: function () {
                    var table = this;
                    jQuery(this).jqGrid('filterToolbar', {searchOperators: true});
                    setTimeout(function () {
                        styleCheckbox(table);
                        updateActionIcons(table);
                        updatePagerIcons(table);
                        enableTooltips(table);
                    }, 0);
                },
                editurl: "${contextPath}/olympic_games/edit"
                //caption : "用户管理列表",
                //autowidth : true,
                /**
                 grouping : true,
                 groupingView : {
        				 groupField : ['name'],
        				 groupDataSorted : true,
        				 plusicon : 'fa fa-chevron-down bigger-110',
        				 minusicon : 'fa fa-chevron-up bigger-110'
        			},
                 */
            });

            $(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size

            // enable search/filter toolbar
            // jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
            // jQuery(grid_selector).filterToolbar({});
            // switch element when editing inline
            function aceSwitch(cellvalue, options, cell) {
                setTimeout(function () {
                    $(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
                }, 0);
            }


            // enable datepicker
            function pickDate(cellvalue, options, cell) {
                setTimeout(function () {
                    $(cell).find('input[type=text]').datepicker({
                        format: 'yyyy-mm-dd',
                        autoclose: true,
                        language: 'zh-CN'
                    });
                }, 0);
            }

            // navButtons
            jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options

                add: false,
                edit: true,
                addicon: 'ace-icon fa fa-plus-circle purple',
                del: <shiro:hasPermission name="${ROLE_KEY}:luck_user:delete">false</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:luck_user:delete">false</shiro:lacksPermission>,
                delicon: 'ace-icon fa fa-trash-o red',
                search: <shiro:hasPermission name="${ROLE_KEY}:luck_user:search">false</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:luck_user:search">false</shiro:lacksPermission>,
                searchicon: 'ace-icon fa fa-search orange',
                refresh: true,
                refreshicon: 'ace-icon fa fa-refresh blue',
                view: <shiro:hasPermission name="${ROLE_KEY}:luck_user:view">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:luck_user:view">false</shiro:lacksPermission>,
                viewicon: 'ace-icon fa fa-search-plus grey'
            }, {
                // edit record form
                // closeAfterEdit: true,
                // width: 700,
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                    style_edit_form(form);
                },
                errorTextFormat: function (response) {
                    var result = eval('(' + response.responseText + ')');
                    return result.message;
                }
            }, {
                // new record form
                // width: 700,
                closeAfterAdd: true,
                recreateForm: true,
                viewPagerButtons: false,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                    style_edit_form(form);
                },
                errorTextFormat: function (response) {
                    var result = eval('(' + response.responseText + ')');
                    return result.message;
                }
            }, {
                // delete record form
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    if (form.data('styled'))
                        return false;
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                    style_delete_form(form);
                    form.data('styled', true);
                },
                onClick: function (e) {
                    // alert(1);
                }
            }, {
                // search form
                recreateForm: true,
                afterShowSearch: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                    style_search_form(form);
                },
                afterRedraw: function () {
                    style_search_filters($(this));
                },
                multipleSearch: true
                /**
                 * multipleGroup:true, showQuery: true
                 */
            }, {
                // view record form
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                }
            })

            // add custom button to export the data to excel
            if (<shiro:hasPermission name="${ROLE_KEY}:user:export">false</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:user:export">false</shiro:lacksPermission>) {
                jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector, {
                    caption: "",
                    title: "导出Excel",
                    buttonicon: "ace-icon fa fa-file-excel-o green",
                    onClickButton: function () {
                        var keys = [], ii = 0, rows = "";
                        var ids = $(grid_selector).getDataIDs(); // Get All IDs
                        var row = $(grid_selector).getRowData(ids[0]); // Get First row to get the labels
                        //var label = $(grid_selector).jqGrid('getGridParam','colNames');
                        for (var k in row) {
                            keys[ii++] = k; // capture col names
                            rows = rows + k + "\t"; // output each Column as tab delimited
                        }
                        rows = rows + "\n"; // Output header with end of line
                        for (i = 0; i < ids.length; i++) {
                            row = $(grid_selector).getRowData(ids[i]); // get each row
                            for (j = 0; j < keys.length; j++)
                                rows = rows + row[keys[j]] + "\t"; // output each Row as tab delimited
                            rows = rows + "\n"; // output each row with end of line
                        }
                        rows = rows + "\n"; // end of line at the end
                        var form = "<form name='csvexportform' action='${contextPath}/sys/user/edit?oper=excel' method='post'>";
                        form = form + "<input type='hidden' name='csvBuffer' value='" + encodeURIComponent(rows) + "'>";
                        form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
                        OpenWindow = window.open('', '');
                        OpenWindow.document.write(form);
                        OpenWindow.document.close();
                    }
                });
            }

            function style_edit_form(form) {
                // enable datepicker on "birthday" field and switches for "stock" field
                form.find('input[name=birthday]').datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    language: 'zh-CN'
                })

                form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
                // don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
                // .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

                // update buttons classes
                var buttons = form.next().find('.EditButton .fm-button');
                buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
                buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
                buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

                buttons = form.next().find('.navButton a');
                buttons.find('.ui-icon').hide();
                buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
                buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
            }

            function style_delete_form(form) {
                var buttons = form.next().find('.EditButton .fm-button');
                buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
                buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
                buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
            }

            function style_search_filters(form) {
                form.find('.delete-rule').val('X');
                form.find('.add-rule').addClass('btn btn-xs btn-primary');
                form.find('.add-group').addClass('btn btn-xs btn-success');
                form.find('.delete-group').addClass('btn btn-xs btn-danger');
            }

            function style_search_form(form) {
                var dialog = form.closest('.ui-jqdialog');
                var buttons = dialog.find('.EditTable')
                buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
                buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
                buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
            }

            function beforeDeleteCallback(e) {
                var form = $(e[0]);
                if (form.data('styled'))
                    return false;
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);
                form.data('styled', true);
            }


            function beforeEditCallback(e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }

            // it causes some flicker when reloading or navigating grid
            // it may be possible to have some custom formatter to do this as the grid is being created to prevent this
            // or go back to default browser checkbox styles for the grid
            function styleCheckbox(table) {
                /**
                 * $(table).find('input:checkbox').addClass('ace') .wrap('<label />') .after('<span class="lbl align-top" />') $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
                 * .find('input.cbox[type=checkbox]').addClass('ace') .wrap('<label />').after('<span class="lbl align-top" />');
                 */
            }

            // unlike navButtons icons, action icons in rows seem to be hard-coded
            // you can change them like this in here if you want
            function updateActionIcons(table) {
                /**
                 * var replacement = { 'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue', 'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red', 'ui-icon-disk' : 'ace-icon fa fa-check green', 'ui-icon-cancel' :
        			 * 'ace-icon fa fa-times red' }; $(table).find('.ui-pg-div span.ui-icon').each(function(){ var icon = $(this); var $class = $.trim(icon.attr('class').replace('ui-icon', '')); if($class in replacement)
        			 * icon.attr('class', 'ui-icon '+replacement[$class]); })
                 */
            }

            // replace icons with FontAwesome icons like above
            function updatePagerIcons(table) {
                var replacement = {
                    'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
                    'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
                    'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
                    'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
                };
                $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
                    var icon = $(this);
                    var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

                    if ($class in replacement)
                        icon.attr('class', 'ui-icon ' + replacement[$class]);
                })
            }

            function enableTooltips(table) {
                $('.navtable .ui-pg-button').tooltip({
                    container: 'body'
                });
                $(table).find('.ui-pg-div').tooltip({
                    container: 'body'
                });
            }

            // var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

            $(document).one('ajaxloadstart.page', function (e) {
                $(grid_selector).jqGrid('GridUnload');
                $('.ui-jqdialog').remove();
            });

        });
    })
    ;

</script>
<script type="text/javascript" src="${contextPath}/static/assets/js/jquery.validate.js"></script>
<script type="text/javascript" src="${contextPath}/static/assets/js/tooltip.js"></script>
<script type="text/javascript" src="${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js"></script>
<script type="text/javascript"
        src="${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>

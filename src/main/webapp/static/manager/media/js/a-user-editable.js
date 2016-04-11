var TableEditable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[6].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[6] + '">';
                jqTds[7].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[7] + '">';
                jqTds[9].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[9] + '">';
                jqTds[10].innerHTML = '<a class="edit" href="">Save</a>';
                jqTds[11].innerHTML = '<a class="cancel" href="">Cancel</a>';
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                var a = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
                if (!a.test(jqInputs[1].value)||!a.test(jqInputs[2].value)) {
                    alert("金额格式不正确！");
                    return false;
                }
                if(parseInt(jqInputs[2].value)>parseInt(jqInputs[1].value)){
                    alert("会员价应小于市场价！");
                    return false;
                    }
                var sum= /^[1-9]\d*$/;
                if (jqInputs[3].value == "" || jqInputs[3].value.length > 20 || !sum.test(jqInputs[3].value)) {
                    alert("存量格式不正确！");
                    return false;
                }
                $.ajax({
                    type: "post", //请求方式
                     async: false, //同步和异步的参数
                    dataType: "json",
                    url: "bookEdit?id="+jqInputs[0].value+"&marketprice="+jqInputs[1].value+"&memberprice="+
                    jqInputs[2].value+"&inventory="+jqInputs[3].value,
                    // data: params,
                    success: function (data) {
                       alert("修改成功");
                    }
                });

                oTable.fnUpdate(jqInputs[1].value, nRow, 6, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 7, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 9, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 10, false);
                oTable.fnUpdate('<a class="delete" href="bookDelet?id='+jqInputs[0].value+'">Delete</a>', nRow, 11, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnDraw();
            }

            var oTable = $('#sample_editable_1').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 5,
                "aaSorting": [[8,"desc"]],
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ ",
                    "sSearch": "搜索",
                    "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });

            jQuery('#sample_editable_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
            jQuery('#sample_editable_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
            jQuery('#sample_editable_1_wrapper .dataTables_length select').select2({
                showSearchInput : false //hide search box with special css class
            }); // initialzie select2 dropdown

            var nEditing = null;

            $('#sample_editable_1_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                        '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            //$('#sample_editable_1 a.delete').live('click', function (e) {
            //    e.preventDefault();
            //
            //    if (confirm("你确定删除?") == false) {
            //        return false;
            //    }
            //    var nRow = $(this).parents('tr')[0];
            //    oTable.fnDeleteRow(nRow);
            //  //  alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            //});

            $('#sample_editable_1 a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#sample_editable_1 a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Save") {
                    /* Editing this row and want to save it */
                    saveRow(oTable, nEditing);
                    nEditing = null;
                  //  alert("Updated! Do not forget to do some ajax to sync with backend :)");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();
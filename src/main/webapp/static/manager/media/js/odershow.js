var TableAdvanced = function () {

    var initTable1 = function() {

        /* Formating function for row details */
        function fnFormatDetails ( oTable, nTr )
        {
            var aData = oTable.fnGetData( nTr );
            var sOut="";
            $.ajax({
                type: "post", //请求方式
                async: false, //同步和异步的参数
                dataType: "json",
                url: "getOderDetails", //发送请求地址
                 data: {oderid:aData[1]},
                success: function (data) {
                    sOut+= '<table  border="1" width="400px"><thead><tr><td>书名</td><td>数量(本)</td><td>价格(元)</td></tr></thead>';
                    sOut+='<tbody>';
                    $.each(data, function (index, value) {
                       sOut +='<tr><td>' + value.book.name + '</td><td>'+value.num+'</td><td>'+value.price+'</td></tr>';
                    });
                    sOut += '</tbody></table>';
                }
            });
            return sOut;
        }

        /*
         * Insert a 'details' column to the table
         */
        var nCloneTh = document.createElement( 'th' );
        var nCloneTd = document.createElement( 'td' );
        nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';
         
        $('#sample_1 thead tr').each( function () {
            this.insertBefore( nCloneTh, this.childNodes[0] );
        } );
         
        $('#sample_1 tbody tr').each( function () {
            this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
        } );
         
        /*
         * Initialse DataTables, with no sorting on the 'details' column
         */
        var oTable = $('#sample_1').dataTable( {
            "aoColumnDefs": [
                {"bSortable": false, "aTargets": [ 0 ] }
            ],
            "aaSorting": [[1, 'asc']],
             "aLengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],
            // set the initial value
            "iDisplayLength": 5
        });

        jQuery('#sample_1_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
        jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
        jQuery('#sample_1_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown
         
        /* Add event listener for opening and closing details
         * Note that the indicator for showing which row is open is not controlled by DataTables,
         * rather it is done here
         */
        $('#sample_1').on('click', ' tbody td .row-details', function () {
            var nTr = $(this).parents('tr')[0];
            if ( oTable.fnIsOpen(nTr) )
            {
                /* This row is already open - close it */
                $(this).addClass("row-details-close").removeClass("row-details-open");
                oTable.fnClose( nTr );
            }
            else
            {
                /* Open this row */                
                $(this).addClass("row-details-open").removeClass("row-details-close");
                oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
            }
        });
    }

     var initTable2 = function() {
        var oTable = $('#sample_2').dataTable( {           
            "aoColumnDefs": [
                { "aTargets": [ 0 ] }
            ],
            "aaSorting": [[1, 'asc']],
             "aLengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],
            // set the initial value
            "iDisplayLength": 5
        });

        jQuery('#sample_2_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
        jQuery('#sample_2_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
        jQuery('#sample_2_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown

        $('#sample_2_column_toggler input[type="checkbox"]').change(function(){
            /* Get the DataTables object again - this is not a recreation, just a get of the object */
            var iCol = parseInt($(this).attr("data-column"));
            var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
            oTable.fnSetColumnVis(iCol, (bVis ? false : true));
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            
            if (!jQuery().dataTable) {
                return;
            }

            initTable1();
            initTable2();
        }

    };

}();
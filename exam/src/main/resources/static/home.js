function formToJson() {
    var jsonObj = {};
    var formSerializeArr = $("#text-form").serializeArray();
    jQuery.map( formSerializeArr, function( n, i ) {
        jsonObj[n.name] = n.value;
    });

   
    return JSON.stringify(jsonObj);
}

$(document).ready(function () {

    

    var table = $("#text-table").DataTable({
        ajax: {
            url: "/analytics",
            dataSrc: "",
        },
        columns: [
            { data: "author" },
            { data: "title" },
            { data: "category" },
            { data: "text" },
            { data: "uniqueWordCount" },
            { data: "wordOccurances" },
        ]
    });

    
    var form = $("#text-form")
    form.submit(function (event) {
        event.preventDefault();
        $.ajax({
            url: "/textEntities",
            contentType: "application/json",
            method: "POST",
            data: formToJson(),
            success: function(){
                table.ajax.reload();
                form[0].reset();
            }
        })
    })

})
function checkSurvey() {
    var productId = $("#productId").find(":selected").val();
    if(productId == 0) {
        $("#survey-layout").hide();
    } else {
        $("#survey-layout").show();
    }
}

function submitSurvey() {
    var productId = $("#productId").find(":selected").val();
    var price = $("#price").val();
    var price = $("#notes").val();
    console.log("productid= "+ productId+ "price = "+ price +"notes = "+notes);
    if(!productId && productId === 0 ) {
        alert("Please select product first");
        return false;
    } else if(!price && price == '') {
        alert("Please enter product price");
        return false;
    } else if(!notes && notes == '') {
        alert("Please enter your notes");
        return false;
    } else   {
        return true;
    }
    return true;
}

function getProductDetail() { alert("hello")
    var productId = $("#viewproductId").find(":selected").val();
    if(!productId && productId === 0 ) {
        alert("Please select product first");
        return false;
    } else {
        return true;
    }
}

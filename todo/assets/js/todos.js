// check off specific todos by clicking 

$("ul").on("click", "li",function(){ //when an LI inside of a UL is clicked
    //if li is gray, turn black ...
    $(this).toggleClass("completed");
});

$("li").on("click","span",function(event){  //when a Span is clicked insde an LI
    //click on x to delete todo
    $(this).parent().fadeOut("500", function(){
        $(this).remove();
    });
    event.stopPropagation(); //stop event bubbling 
});

$("input[type ='text']").keypress(function(event){
  if(event.which === 13){  //keypress is the enter key
     var todoText =  $(this).val();  //grab new Todo text from input
     //create a enw LI and add to UL
     $(this).val(" ");
     $("ul").append("<li><span><i class ='fa fa-trash'></i></span> " + todoText + "</li>");
  }
});

$(".fa-plus").on("click", function(){
    $("input[type ='text']").fadeToggle()
});

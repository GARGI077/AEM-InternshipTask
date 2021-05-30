//To set the color of the select button on dialog load
$(document).on("foundation-contentloaded", function(e) {
    bgColorSelect.colorfulSelector();
});

//To change the color of the select button on option select
$(document).on ("click", ".colorfulDropdown ul", function(e) {
    bgColorSelect.colorfulSelector();
});
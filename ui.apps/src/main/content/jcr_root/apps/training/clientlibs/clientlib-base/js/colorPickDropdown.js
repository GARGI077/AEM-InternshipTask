let bgColorSelect = {
       colorfulSelector : function() {
    	//The dropdown itself
        let dropdown = $('.colorfulDropdown ul');
        //The select button for opening the dropdown
        let selectButton = $('.colorfulDropdown button');
        //The list of options
        let optionList = dropdown.children();
        if (optionList.length > 0) {
          for (let i = 0; i < optionList.length; i++) {
           //The color's hex valuestored as an option
           let optionValue = optionList[i].getAttribute("data-value");
           if (optionValue) {
             //Set the background of the option
             $(optionList[i]).css("background-color", optionValue);
             //Make the border white
             $(optionList[i]).css("border-style", "solid");
             //Make the select button the same color as the selected option,
even when the dialog has just been loaded
             if($(optionList[i]).hasClass("is-highlighted") ||
$(optionList[i]).attr("aria-selected")==="true"){
              $(selectButton).css("background-color", optionValue);
            }
          }
          else {
            //If the option has no value, make the background transparent
            $(selectButton).css("background-color", "transparent");
          }
        }
      }
    }
};
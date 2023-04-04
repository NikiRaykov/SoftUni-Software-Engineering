function lockedProfile() {
   // We select all buttons
   const buttons = Array.from(document.getElementsByTagName('button'));

   buttons.forEach((button) => {
        button.addEventListener('click', toggleInfo);
   })

   function toggleInfo(e) {
        const btn = e.currentTarget; 
        const currentProfile = btn.parentElement; // We take the parent of the button
        const children = Array.from(currentProfile.children); // Collection of all divs in profile
        const unlockRadioButton = children[4]; // We need this to check if profile is locked or not
        const additionalInfoDiv = children[9];


        if (unlockRadioButton.checked) {
            if (btn.textContent === 'Show more') {
                additionalInfoDiv.style.display = 'block';
                btn.textContent = 'Hide it';
            } else {
                additionalInfoDiv.style.display = 'none';
                btn.textContent = 'Show more';
            }
        }  
   }
}
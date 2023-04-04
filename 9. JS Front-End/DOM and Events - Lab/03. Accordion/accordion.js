function toggle() {
    const button = document.getElementsByClassName('button')[0];
    const hiddenText = document.getElementById('extra');

    if (button.textContent === 'More') {
        button.textContent = 'Less'
        hiddenText.style.display = 'block';
    } else {
        button.textContent = 'More';
        hiddenText.style.display = 'none';
    }
}

/*An HTML file is given and your task is to show more/less information. 
By clicking the [More] button, it should reveal the content of a hidden div and changes the text of the button to [Less]. 
When the same link is clicked again (now reading Less), hide the div and change 
the text of the link to More. Link action should be toggleable
(you should be able to click the button an infinite amount of times).*/
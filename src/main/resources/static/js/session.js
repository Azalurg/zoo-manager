const getCookie = (name) => {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}

window.onload = function () {
    const sk = getCookie('sessionKey');
    if (!sk) return;

    // Get all links
    const allLinks = document.querySelectorAll("a");

    // Add session key as query parameter to href attributes of all links
    allLinks.forEach(link => {
        let currentHref = link.getAttribute("href");
        if(currentHref.indexOf("?") === -1){
        currentHref += `?sessionKey=${sk}`;
        }else{
            currentHref += `&sessionKey=${sk}`;
        }
        link.setAttribute("href", currentHref);
   });
};


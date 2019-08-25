/**
 * 
 */

function importJS(src){   
    var script=document.createElement('script')
    script.setAttribute("type","text/javascript")
    script.setAttribute("src", src)
    
    if (typeof script!="undefined")
        document.getElementsByTagName("head")[0].appendChild(script)
}

function importCSS(src){    
    var link=document.createElement("link")
    link.setAttribute("rel", "stylesheet")
    link.setAttribute("type", "text/css")
    link.setAttribute("href", src)
        
    if (typeof link!="undefined")
        document.getElementsByTagName("head")[0].appendChild(link)
}

var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function() {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i) || navigator.userAgent.match(/WPDesktop/i);
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};

/*function isOrIsAncestorOf(ancestor, descendant) {
	  var n = descendant;
	  while (n) {
	    if (n === ancestor) {
	      return true;
	    } else {
	      n = n.parentNode;
	    }
	  }
	  return false;
	}

	function nodeContainsSelection(node) {
	  var sel, range;
	  if (window.getSelection && (sel = window.getSelection()).rangeCount) {
	    range = sel.getRangeAt(0);
	    return isOrIsAncestorOf(node, range.commonAncestorContainer);
	  }
	  return false;
	}

	function insertHTML() {
	  var sel, range;
	  if (window.getSelection && (sel = window.getSelection()).rangeCount) {
	    range = sel.getRangeAt(0);
	    range.collapse(true);
	    var span = document.createElement("span");
	    span.id = "myId";
	    span.appendChild( document.createTextNode("hi") );
	    range.insertNode(span);

	    // Move the caret immediately after the inserted span
	    range.setStartAfter(span);
	    range.collapse(true);
	    sel.removeAllRanges();
	    sel.addRange(range);
	  }
	}

	window.onload = function() {
	  document.getElementById("inserter").onmousedown = function() {
	    var editor = document.getElementById("editor");
	    if (nodeContainsSelection(editor)) {
	      insertHTML();
	      return false;
	    }
	  };
	};
 */
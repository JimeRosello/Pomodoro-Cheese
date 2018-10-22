// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn()
        }).ajaxStop(function() {
            $('#spinner').fadeOut()
        })
    })(jQuery)
}

function loadPage(page) {
    document.getElementsByClassName("popup")[0].innerHTML =
      '<a class="close" href="#" onclick="closePopup();">[X]</a><embed src="'+
      page +'" type="text/html" class="popup-content"/></embed>';
}

function openPopup() {
  document.getElementsByClassName('popup')[0].style.visibility='visible';
  document.getElementById('black-screen').style.visibility='visible';
  document.getElementById('black-screen').style.opacity="0.8";
  loadPage('/task/create');
}

function closePopup() {
  document.getElementsByClassName('popup')[0].style.visibility='hidden';
  document.getElementById('black-screen').style.visibility='hidden';
  document.getElementById('black-screen').style.opacity="0";
}

/**
 * 
 */

$(function() {
	$('.dropdown-menu').find('form').click(function(e) {
		e.stopPropagation();
	});

	$('.datepicker').datepicker({
		format : 'mm/dd/yyyy',
		
	});

	jQuery('.datepicker').on('focus', function() {
		jQuery(this).blur();
	});
	
	$('#login-btn').click(function(){
		
	});
	
	$('#signup-btn').click(function(){
		
	});
	
	$('.scroll').jscroll({
		loadingHtml: '<img src="loading.gif" alt="Loading" /> Loading...',
	    padding: 20,
	    nextSelector: 'a.jscroll-next:last',
	    contentSelector: 'div'
	});
});
$(document).ready(function() {

    /* For the sticky navigation */
    $('.js--topbar').waypoint(function(direction) {
        if (direction === "down") {
            $('.main-nav').addClass('sticky');
        } else {
            $('.main-nav').removeClass('sticky');}
    },
        {offset: '50px;'}
    );
/*
    $('.js--topbar')
        .css('opacity', 0)
        .waypoint(function(direction) {
            if (direction === 'down') {
                $(this.element).animate({ opacity: 1 })
            }
            else {
                $(this.element).animate({ opacity: 0 })
            }
        }, {
            offset: 'bottom-in-view'
        });
*/
    /* Animations on scroll */
    $('.js--wp-1').waypoint(function(direction) {
        $('.js--wp-1').addClass('animated fadeInUp');
    }, {
        offset: '50%'
    });


});
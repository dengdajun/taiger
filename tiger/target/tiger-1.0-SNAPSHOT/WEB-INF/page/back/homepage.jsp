<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="alert alert-block alert-success">
			<button type="button" class="close" data-dismiss="alert">
				<i class="ace-icon fa fa-times"></i>
			</button>
			<strong class="green">
				太阁官网
			</strong>
		</div>


					</div><!-- /.widget-body -->
				</div><!-- /.widget-box -->
			</div><!-- /.col -->
		</div><!-- /.row -->

		<!-- #section:custom/extra.hr -->


		<!-- /section:custom/extra.hr -->




									<!-- /section:pages/dashboard.tasks -->




<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="${contextPath}/static/assets/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
		var scripts = [ null, "${contextPath}/static/assets/js/jquery-ui.custom.js", "${contextPath}/static/assets/js/jquery.ui.touch-punch.js", "${contextPath}/static/assets/js/jquery.easypiechart.js", "${contextPath}/static/assets/js/jquery.sparkline.js",
        		"${contextPath}/static/assets/js/flot/jquery.flot.js", "${contextPath}/static/assets/js/flot/jquery.flot.pie.js", "${contextPath}/static/assets/js/flot/jquery.flot.resize.js", "${contextPath}/static/assets/js/activities-serverload.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		$('.easy-pie-chart.percentage').each(function() {
        			var $box = $(this).closest('.infobox');
        			var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
        			var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
        			var size = parseInt($(this).data('size')) || 50;
        			$(this).easyPieChart({
        				barColor : barColor,
        				trackColor : trackColor,
        				scaleColor : false,
        				lineCap : 'butt',
        				lineWidth : parseInt(size / 10),
        				animate : /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
        				size : size
        			});
        		})

        		$('.sparkline').each(function() {
        			var $box = $(this).closest('.infobox');
        			var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
        			$(this).sparkline('html', {
        				tagValuesAttribute : 'data-values',
        				type : 'bar',
        				barColor : barColor,
        				chartRangeMin : $(this).data('min') || 0
        			});
        		});

        		// flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
        		// but sometimes it brings up errors with normal resize event handlers
        		$.resize.throttleWindow = false;



        		/**
        		 * we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically so that's not needed actually.
        		 */


        		// pie chart tooltip example
        		var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
        		var previousPoint = null;






        		// show the dropdowns on top or bottom depending on window height and menu position



        	})
        });
		
</script>

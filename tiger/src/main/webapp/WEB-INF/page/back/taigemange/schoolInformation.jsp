<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.custom.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery.gritter.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/select2.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap-editable.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
	<h1>
		个人资料页面
	</h1>
</div><!-- /.page-header -->

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="hr dotted"></div>

		<div>
			<div id="user-profile-1" class="user-profile row">
				<div class="col-xs-12 col-sm-1 center">
					<div>
						<span class="profile-picture">
							<img id="avatar1" class="editable img-responsive" alt="Alex's Avatar" src="${contextPath}/${banner1.filePath}" />
						</span>
						<span class="profile-picture">
							<img id="avatar2" class="editable img-responsive" alt="Alex's Avatar" src="${contextPath}/${banner2.filePath}" />
						</span>
						<span class="profile-picture">
							<img id="avatar3" class="editable img-responsive" alt="Alex's Avatar" src="${contextPath}/${banner3.filePath}" />
						</span>
						<span class="profile-picture">
							<img id="avatar4" class="editable img-responsive" alt="Alex's Avatar"  />
						</span>
						<div class="space-4"></div>
					</div>0

				<!-- #section:pages/profile.info -->
				<div class="profile-user-info profile-user-info-striped">
					<c:set var="id" value="${information.id}" />
					<div class="profile-info-row">
						<div class="profile-info-name"> 手机 </div>
						<div class="profile-info-value">
							<span class="editable" id="mobile">${information.mobile}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> qq </div>
						<div class="profile-info-value">
							<span class="editable" id="qq">${information.QQ}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> qq群  </div>
						<div class="profile-info-value">
							<span class="editable" id="qqgroup" >${information.QQgroup}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 联系电话  </div>
						<div class="profile-info-value">
							<span class="editable" id="tel">${information.tel}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 介绍  </div>
						<div class="profile-info-value">
							<span class="editable" id="introduce">${information.introduce}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 路线  </div>
						<div class="profile-info-value">
							<span class="editable" id="route">${information.route}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 路线详情  </div>
						<div class="profile-info-value">
							<span class="editable" id="routedetails">${information.routedetails}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 环境  </div>
						<div class="profile-info-value">
							<span class="editable" id="environment">${information.environment}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 地址  </div>
						<div class="profile-info-value">
							<span class="editable" id="address">${information.address}</span>
						</div>
					</div>


					<c:set var="qqid" value="${qqAdvertisement.id}" />
					<div class="profile-info-row">
						<div class="profile-info-name"> qq交谈内容 </div>
						<div class="profile-info-value">
							<span class="editable" id="talk">${qqAdvertisement.talk}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">不能交谈留言 </div>
						<div class="profile-info-value">
							<span class="editable" id="message">${qqAdvertisement.message}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name"> 工作时间 </div>
						<div class="profile-info-value">
							<span class="editable" id="time">${qqAdvertisement.time}</span>
						</div>
					</div>
					</div>
				<!-- /section:pages/profile.info -->
				<div class="space-20"></div>

			</div>
		</div>
	</div>


	<!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${contextPath}/static/assets/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
	var scripts = [null,"${contextPath}/static/assets/js/jquery-ui.custom.js","${contextPath}/static/assets/js/jquery.ui.touch-punch.js","${contextPath}/static/assets/js/jquery.gritter.js","${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js","${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js","${contextPath}/static/assets/js/select2.js","${contextPath}/static/assets/js/x-editable/bootstrap-editable.js","${contextPath}/static/assets/js/x-editable/ace-editable.js", null]
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		//inline scripts related to this page
		jQuery(function($) {

			//editables on first profile page
			$.fn.editable.defaults.mode = 'inline';
			$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
			$.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>' +
					'<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';

			//select2 editable 实现网页文本即时编辑
			$('#mobile').editable({
				type: 'text',
				pk: ${id},
				name: 'mobile',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#qq').editable({
				type: 'text',
				pk: ${id},
				name: 'QQ',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			//text editable
			$('#qqgroup').editable({
				type: 'text',
				pk: ${id},
				name: 'QQgroup',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#tel').editable({
				type: 'text',
				pk: ${id},
				name: 'tel',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#introduce').editable({
				type: 'text',
				pk: ${id},
				name: 'introduce',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#route').editable({
				type: 'text',
				pk: ${id},
				name: 'route',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#routedetails').editable({
				type: 'text',
				pk: ${id},
				name: 'routedetails',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#environment').editable({
				type: 'text',
				pk: ${id},
				name: 'environment',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"
			});
			$('#address').editable({
				type: 'text',
				pk: ${id},
				name: 'address',
				url: "${contextPath}" + "/taige/schoolInformation/updateInformationField"

			});
			$('#talk').editable({
				type: 'text',
				pk: ${qqid},
				name: 'talk',
				url: "${contextPath}" + "/taige/schoolInformation/updateqqField"

			});
			$('#message').editable({
				type: 'text',
				pk: ${qqid},
				name: 'message',
				url: "${contextPath}" + "/taige/schoolInformation/updateqqField"

			});
			$('#time').editable({
				type: 'text',
				pk: ${qqid},
				name: 'time',
				url: "${contextPath}" + "/taige/schoolInformation/updateqqField"

			});

			// *** editable avatar *** //
			try {
				//ie8 throws some harmless exceptions, so let's catch'em
				//first let's add a fake appendChild method for Image element for browsers that have a problem with this
				//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
				try {
					document.createElement('IMG').appendChild(document.createElement('B'));
				} catch (e) {
					Image.prototype.appendChild = function(el) {}
				}

				var last_gritter;
				$('#avatar1').editable({
					type: 'image',
					name: 'avatar',
					value: null,
					image: {
						//specify ace file input plugin's options here
						btn_choose: '更改此轮播',
						droppable: true,
						maxSize: 2097152, //~100Kb
						//and a few extra ones here
						name: 'avatar', //put the field name here as well, will be used inside the custom plugin
						on_error: function(error_type) { //on_error function will be called when the selected file has a problem
							if (last_gritter) $.gritter.remove(last_gritter);
							if (error_type == 1) { //file format error
								last_gritter = $.gritter.add({
									title: '文件格式不正确!',
									text: '请选择  jpg|gif|png 格式的图片!',
									class_name: 'gritter-error gritter-center'
								});
							} else if (error_type == 2) { //file size rror
								last_gritter = $.gritter.add({
									title: '文件太大!',
									text: '图片大小不能超过2mb!',
									class_name: 'gritter-error gritter-center'
								});
							} else { //other error
							}
						},
						on_success: function() {
							$.gritter.removeAll();
						}
					},
					url: function(params) {
						//for a working upload example you can replace the contents of this function with
						//examples/profile-avatar-update.js

						//this is similar to the file-upload.html example
						//replace the code inside profile page where it says ***UPDATE AVATAR HERE*** with the code below
						// ***UPDATE AVATAR HERE*** //
						var submit_url = "${contextPath}" + "/taige/schoolInformation/uploadAttachement1";//please modify submit_url accordingly
						var deferred = null;
						var avatar = '#avatar1';

						//if value is empty (""), it means no valid files were selected
						//but it may still be submitted by x-editable plugin
						//because "" (empty string) is different from previous non-empty value whatever it was
						//so we return just here to prevent problems
						var value = $(avatar).next().find('input[type=hidden]:eq(0)').val();
						if(!value || value.length == 0) {
							deferred = new $.Deferred
							deferred.resolve();
							return deferred.promise();
						}

						var $form = $(avatar).next().find('.editableform:eq(0)')
						var file_input = $form.find('input[type=file]:eq(0)');
						var pk = $(avatar).attr('data-pk');//primary key to be sent to server

						var ie_timeout = null


						if( "FormData" in window ) {
							var formData_object = new FormData();//create empty FormData object

							//serialize our form (which excludes file inputs)
							$.each($form.serializeArray(), function(i, item) {
								//add them one by one to our FormData
								formData_object.append(item.name, item.value);
							});
							//and then add files
							$form.find('input[type=file]').each(function(){
								var field_name = $(this).attr('name');
								var files = $(this).data('ace_input_files');
								if(files && files.length > 0) {
									formData_object.append(field_name, files[0]);
								}
							});

							//append primary key to our formData
							formData_object.append('pk', pk);

							deferred = $.ajax({
								url: submit_url,
								type: 'POST',
								processData: false,//important
								contentType: false,//important
								dataType: 'json',//server response type
								data: formData_object
							})
						}
						else {
							deferred = new $.Deferred

							var temporary_iframe_id = 'temporary-iframe-'+(new Date()).getTime()+'-'+(parseInt(Math.random()*1000));
							var temp_iframe =
									$('<iframe id="'+temporary_iframe_id+'" name="'+temporary_iframe_id+'" \
									frameborder="0" width="0" height="0" src="about:blank"\
									style="position:absolute; z-index:-1; visibility: hidden;"></iframe>')
											.insertAfter($form);

							$form.append('<input type="hidden" name="temporary-iframe-id" value="'+temporary_iframe_id+'" />');

							//append primary key (pk) to our form
							$('<input type="hidden" name="pk" />').val(pk).appendTo($form);

							temp_iframe.data('deferrer' , deferred);
							//we save the deferred object to the iframe and in our server side response
							//we use "temporary-iframe-id" to access iframe and its deferred object

							$form.attr({
								action: submit_url,
								method: 'POST',
								enctype: 'multipart/form-data',
								target: temporary_iframe_id //important
							});

							$form.get(0).submit();

							//if we don't receive any response after 30 seconds, declare it as failed!
							ie_timeout = setTimeout(function(){
								ie_timeout = null;
								temp_iframe.attr('src', 'about:blank').remove();
								deferred.reject({'status':'fail', 'message':'Timeout!'});
							} , 30000);
						}


						//deferred callbacks, triggered by both ajax and iframe solution
						deferred.done(function(result) {//success
							var res = result;//the `result` is formatted by your server side response and is arbitrary
							if(res.status == 'OK') $(avatar).get(0).src = res.url;
							else alert(res.message);
						}).fail(function(result) {//failure
							alert("There was an error");
						}).always(function() {//called on both success and failure
							if(ie_timeout) clearTimeout(ie_timeout)
							ie_timeout = null;
						});

						return deferred.promise();
						// ***END OF UPDATE AVATAR HERE*** //
					},
					success: function(response, newValue) {

					}
				})
			} catch (e) {

			}
			// *** editable avatar *** //
			try {
				//ie8 throws some harmless exceptions, so let's catch'em
				//first let's add a fake appendChild method for Image element for browsers that have a problem with this
				//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
				try {
					document.createElement('IMG').appendChild(document.createElement('B'));
				} catch (e) {
					Image.prototype.appendChild = function(el) {}
				}

				var last_gritter;
				$('#avatar2').editable({
					type: 'image',
					name: 'avatar',
					value: null,
					image: {
						//specify ace file input plugin's options here
						btn_choose: '更改此轮播',
						droppable: true,
						maxSize: 2097152, //~100Kb
						//and a few extra ones here
						name: 'avatar', //put the field name here as well, will be used inside the custom plugin
						on_error: function(error_type) { //on_error function will be called when the selected file has a problem
							if (last_gritter) $.gritter.remove(last_gritter);
							if (error_type == 1) { //file format error
								last_gritter = $.gritter.add({
									title: '文件格式不正确!',
									text: '请选择  jpg|gif|png 格式的图片!',
									class_name: 'gritter-error gritter-center'
								});
							} else if (error_type == 2) { //file size rror
								last_gritter = $.gritter.add({
									title: '文件太大!',
									text: '图片大小不能超过2mb!',
									class_name: 'gritter-error gritter-center'
								});
							} else { //other error
							}
						},
						on_success: function() {
							$.gritter.removeAll();
						}
					},
					url: function(params) {
						//for a working upload example you can replace the contents of this function with
						//examples/profile-avatar-update.js

						//this is similar to the file-upload.html example
						//replace the code inside profile page where it says ***UPDATE AVATAR HERE*** with the code below
						// ***UPDATE AVATAR HERE*** //
						var submit_url = "${contextPath}" + "/taige/schoolInformation/uploadAttachement2";//please modify submit_url accordingly
						var deferred = null;
						var avatar = '#avatar2';

						//if value is empty (""), it means no valid files were selected
						//but it may still be submitted by x-editable plugin
						//because "" (empty string) is different from previous non-empty value whatever it was
						//so we return just here to prevent problems
						var value = $(avatar).next().find('input[type=hidden]:eq(0)').val();
						if(!value || value.length == 0) {
							deferred = new $.Deferred
							deferred.resolve();
							return deferred.promise();
						}

						var $form = $(avatar).next().find('.editableform:eq(0)')
						var file_input = $form.find('input[type=file]:eq(0)');
						var pk = $(avatar).attr('data-pk');//primary key to be sent to server

						var ie_timeout = null


						if( "FormData" in window ) {
							var formData_object = new FormData();//create empty FormData object

							//serialize our form (which excludes file inputs)
							$.each($form.serializeArray(), function(i, item) {
								//add them one by one to our FormData
								formData_object.append(item.name, item.value);
							});
							//and then add files
							$form.find('input[type=file]').each(function(){
								var field_name = $(this).attr('name');
								var files = $(this).data('ace_input_files');
								if(files && files.length > 0) {
									formData_object.append(field_name, files[0]);
								}
							});

							//append primary key to our formData
							formData_object.append('pk', pk);

							deferred = $.ajax({
								url: submit_url,
								type: 'POST',
								processData: false,//important
								contentType: false,//important
								dataType: 'json',//server response type
								data: formData_object
							})
						}
						else {
							deferred = new $.Deferred

							var temporary_iframe_id = 'temporary-iframe-'+(new Date()).getTime()+'-'+(parseInt(Math.random()*1000));
							var temp_iframe =
									$('<iframe id="'+temporary_iframe_id+'" name="'+temporary_iframe_id+'" \
									frameborder="0" width="0" height="0" src="about:blank"\
									style="position:absolute; z-index:-1; visibility: hidden;"></iframe>')
											.insertAfter($form);

							$form.append('<input type="hidden" name="temporary-iframe-id" value="'+temporary_iframe_id+'" />');

							//append primary key (pk) to our form
							$('<input type="hidden" name="pk" />').val(pk).appendTo($form);

							temp_iframe.data('deferrer' , deferred);
							//we save the deferred object to the iframe and in our server side response
							//we use "temporary-iframe-id" to access iframe and its deferred object

							$form.attr({
								action: submit_url,
								method: 'POST',
								enctype: 'multipart/form-data',
								target: temporary_iframe_id //important
							});

							$form.get(0).submit();

							//if we don't receive any response after 30 seconds, declare it as failed!
							ie_timeout = setTimeout(function(){
								ie_timeout = null;
								temp_iframe.attr('src', 'about:blank').remove();
								deferred.reject({'status':'fail', 'message':'Timeout!'});
							} , 30000);
						}


						//deferred callbacks, triggered by both ajax and iframe solution
						deferred.done(function(result) {//success
							var res = result;//the `result` is formatted by your server side response and is arbitrary
							if(res.status == 'OK') $(avatar).get(0).src = res.url;
							else alert(res.message);
						}).fail(function(result) {//failure
							alert("There was an error");
						}).always(function() {//called on both success and failure
							if(ie_timeout) clearTimeout(ie_timeout)
							ie_timeout = null;
						});

						return deferred.promise();
						// ***END OF UPDATE AVATAR HERE*** //
					},
					success: function(response, newValue) {

					}
				})
			} catch (e) {

			}
			// *** editable avatar *** //
			try {
				//ie8 throws some harmless exceptions, so let's catch'em
				//first let's add a fake appendChild method for Image element for browsers that have a problem with this
				//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
				try {
					document.createElement('IMG').appendChild(document.createElement('B'));
				} catch (e) {
					Image.prototype.appendChild = function(el) {}
				}

				var last_gritter;
				$('#avatar3').editable({
					type: 'image',
					name: 'avatar',
					value: null,
					image: {
						//specify ace file input plugin's options here
						btn_choose: '更改此轮播',
						droppable: true,
						maxSize: 2097152, //~100Kb
						//and a few extra ones here
						name: 'avatar', //put the field name here as well, will be used inside the custom plugin
						on_error: function(error_type) { //on_error function will be called when the selected file has a problem
							if (last_gritter) $.gritter.remove(last_gritter);
							if (error_type == 1) { //file format error
								last_gritter = $.gritter.add({
									title: '文件格式不正确!',
									text: '请选择  jpg|gif|png 格式的图片!',
									class_name: 'gritter-error gritter-center'
								});
							} else if (error_type == 2) { //file size rror
								last_gritter = $.gritter.add({
									title: '文件太大!',
									text: '图片大小不能超过2mb!',
									class_name: 'gritter-error gritter-center'
								});
							} else { //other error
							}
						},
						on_success: function() {
							$.gritter.removeAll();
						}
					},
					url: function(params) {
						//for a working upload example you can replace the contents of this function with
						//examples/profile-avatar-update.js

						//this is similar to the file-upload.html example
						//replace the code inside profile page where it says ***UPDATE AVATAR HERE*** with the code below
						// ***UPDATE AVATAR HERE*** //
						var submit_url = "${contextPath}" + "/taige/schoolInformation/uploadAttachement3";//please modify submit_url accordingly
						var deferred = null;
						var avatar = '#avatar3';

						//if value is empty (""), it means no valid files were selected
						//but it may still be submitted by x-editable plugin
						//because "" (empty string) is different from previous non-empty value whatever it was
						//so we return just here to prevent problems
						var value = $(avatar).next().find('input[type=hidden]:eq(0)').val();
						if(!value || value.length == 0) {
							deferred = new $.Deferred
							deferred.resolve();
							return deferred.promise();
						}

						var $form = $(avatar).next().find('.editableform:eq(0)')
						var file_input = $form.find('input[type=file]:eq(0)');
						var pk = $(avatar).attr('data-pk');//primary key to be sent to server

						var ie_timeout = null


						if( "FormData" in window ) {
							var formData_object = new FormData();//create empty FormData object

							//serialize our form (which excludes file inputs)
							$.each($form.serializeArray(), function(i, item) {
								//add them one by one to our FormData
								formData_object.append(item.name, item.value);
							});
							//and then add files
							$form.find('input[type=file]').each(function(){
								var field_name = $(this).attr('name');
								var files = $(this).data('ace_input_files');
								if(files && files.length > 0) {
									formData_object.append(field_name, files[0]);
								}
							});

							//append primary key to our formData
							formData_object.append('pk', pk);

							deferred = $.ajax({
								url: submit_url,
								type: 'POST',
								processData: false,//important
								contentType: false,//important
								dataType: 'json',//server response type
								data: formData_object
							})
						}
						else {
							deferred = new $.Deferred

							var temporary_iframe_id = 'temporary-iframe-'+(new Date()).getTime()+'-'+(parseInt(Math.random()*1000));
							var temp_iframe =
									$('<iframe id="'+temporary_iframe_id+'" name="'+temporary_iframe_id+'" \
									frameborder="0" width="0" height="0" src="about:blank"\
									style="position:absolute; z-index:-1; visibility: hidden;"></iframe>')
											.insertAfter($form);

							$form.append('<input type="hidden" name="temporary-iframe-id" value="'+temporary_iframe_id+'" />');

							//append primary key (pk) to our form
							$('<input type="hidden" name="pk" />').val(pk).appendTo($form);

							temp_iframe.data('deferrer' , deferred);
							//we save the deferred object to the iframe and in our server side response
							//we use "temporary-iframe-id" to access iframe and its deferred object

							$form.attr({
								action: submit_url,
								method: 'POST',
								enctype: 'multipart/form-data',
								target: temporary_iframe_id //important
							});

							$form.get(0).submit();

							//if we don't receive any response after 30 seconds, declare it as failed!
							ie_timeout = setTimeout(function(){
								ie_timeout = null;
								temp_iframe.attr('src', 'about:blank').remove();
								deferred.reject({'status':'fail', 'message':'Timeout!'});
							} , 30000);
						}


						//deferred callbacks, triggered by both ajax and iframe solution
						deferred.done(function(result) {//success
							var res = result;//the `result` is formatted by your server side response and is arbitrary
							if(res.status == 'OK') $(avatar).get(0).src = res.url;
							else alert(res.message);
						}).fail(function(result) {//failure
							alert("There was an error");
						}).always(function() {//called on both success and failure
							if(ie_timeout) clearTimeout(ie_timeout)
							ie_timeout = null;
						});

						return deferred.promise();
						// ***END OF UPDATE AVATAR HERE*** //
					},
					success: function(response, newValue) {

					}
				})
			} catch (e) {

			}


			/**
			 //let's display edit mode by default?
			 var blank_image = true;//somehow you determine if image is initially blank or not, or you just want to display file input at first
			 if(blank_image) {
				$('#avatar').editable('show').on('hidden', function(e, reason) {
					if(reason == 'onblur') {
						$('#avatar').editable('show');
						return;
					}
					$('#avatar').off('hidden');
				})
			}
			 */

			//right & left position
			//show the user info on right or left depending on its position
			$('#user-profile-2 .memberdiv').on('mouseenter touchstart', function() {
				var $this = $(this);
				var $parent = $this.closest('.tab-pane');
				var off1 = $parent.offset();
				var w1 = $parent.width();
				var off2 = $this.offset();
				var w2 = $this.width();
				var place = 'left';
				if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) place = 'right';
				$this.find('.popover').removeClass('right left').addClass(place);
			}).on('click', function(e) {
				e.preventDefault();
			});

			///////////////////////////////////////////
			$('#user-profile-3').find('input[type=file]').ace_file_input({
				style: 'well',
				btn_choose: 'Change avatar',
				btn_change: null,
				no_icon: 'ace-icon fa fa-picture-o',
				thumbnail: 'large',
				droppable: true,
				allowExt: ['jpg', 'jpeg', 'png', 'gif'],
				allowMime: ['image/jpg', 'image/jpeg', 'image/png', 'image/gif']
			}).end().find('button[type=reset]').on(ace.click_event, function() {
				$('#user-profile-3 input[type=file]').ace_file_input('reset_input');
			}).end().find('.date-picker').datepicker().next().on(ace.click_event, function() {
				$(this).prev().focus();
			})

			$('#user-profile-3').find('input[type=file]').ace_file_input('show_file_list', [{
				type: 'image',
				name: $('#avatar').attr('src')
			}]);

			////////////////////
			$("a[href='#edit-password']").on('shown.bs.tab', function (e) {
			});


			////////////////////
			//change profile
			$('[data-toggle="buttons"] .btn').on('click', function(e) {
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				$('.user-profile').parent().addClass('hide');
				$('#user-profile-' + which).parent().removeClass('hide');
			});

			/////////////////////////////////////
			$(document).one('ajaxloadstart.page', function(e) {
				//in ajax mode, remove remaining elements before leaving page
				try {
					$('.editable').editable('destroy');
				} catch (e) {}
				$('[class*=select2]').remove();
			});
		});

	});
</script>

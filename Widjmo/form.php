<html>

	<!-- connect to mysql -->
	<!-- /connect to mysql -->
	<script src="scripts.js" type="text/javascript"></script>
	<script src="Wijmo-Complete/js/jquery.wijmo-complete.all.2.0.8.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$("#textbox1").wijinputmask({
				mask : '(999) 000-0000',
				hidePromptOnLeave : true
			});
		});
	</script>

	<link href="Wijmo-Complete/development-bundle/themes/rocket/jquery-wijmo.css" rel="stylesheet" type="text/css" />
	<script src="Wijmo-Complete/development-bundle/external/jquery-1.7.1.min.js" type="text/javascript"></script>
	<script src="Wijmo-Complete/development-bundle/external/jquery-ui-1.8.18.custom.min.js" type="text/javascript"></script>
	<link href="Wijmo-Complete/development-bundle/themes/wijmo/jquery.wijmo.wijinput.css" rel="stylesheet" type="text/css" />
	<script src="Wijmo-Complete/development-bundle/external/globalize.min.js" type="text/javascript"></script>
	<script src="Wijmo-Complete/development-bundle/external/jquery.mousewheel.min.js" type="text/javascript"></script>
	<script src="Wijmo-Complete/development-bundle/external/jquery.wijmo-open.all.2.0.8.min.js" type="text/javascript"></script>
	<script src="Wijmo-Complete/development-bundle/wijmo/jquery.plugin.wijtextselection.js" type="text/javascript"></script>
	<script src="Wijmo-Complete/development-bundle/wijmo/jquery.wijmo.wijinputcore.js" type="text/javascript"></script>

	<!-- tabs -->
	<link href="themes/wijmo/jquery.wijmo.wijtabs.css" rel="stylesheet" type="text/css" />

	<script src="wijmo/jquery.wijmo.wijtabs.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(function() {

			$("#tabs").wijtabs({
				showOption : {

					blind : true, //$("#showblind")[0].checked,

					fade : true, //$("#showfade")[0].checked,

					duration : 400//$("#showduration").val()

				}
			});

			$(".show").change(function() {

				$("#tabs").wijtabs({
					showOption : {

						blind : true, //$("#showblind")[0].checked,

						fade : true, //$("#showfade")[0].checked,

						duration : 400//$("#showduration").val()

					}

				});

			});
		});

	</script>
	<!-- /tabs -->

	<!-- editor -->
	<link href="Wijmo-Complete/development-bundle/themes/wijmo/jquery.wijmo-open.2.0.8.css" rel="stylesheet" type="text/css" />

	<link href="Wijmo-Complete/development-bundle/themes/wijmo/jquery.wijmo.wijribbon.css" rel="stylesheet" type="text/css" />

	<link href="Wijmo-Complete/development-bundle/themes/wijmo/jquery.wijmo.wijeditor.css" rel="stylesheet" type="text/css" />

	<script src="Wijmo-Complete/development-bundle/wijmo/jquery.wijmo.wijribbon.js" type="text/javascript"></script>

	<script src="Wijmo-Complete/development-bundle/wijmo/jquery.wijmo.wijeditor.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#wijeditor").wijeditor();

		});

	</script>
	<!-- /editor -->

	<!-- phone mask -->
	<script type="text/javascript">
		$(function () {

		$("#textbox1").wijinputdate({ dateFormat: 'T' });

		$("#textbox2").wijinputdate({ dateFormat: 'd' });

		$("#textbox3").wijinputdate({ dateFormat: 'g' });

		$("#textbox4").wijinputdate({ dateFormat: 'U' });

		});
		<!-- /phone mask -->
	</script>
	<link rel="stylesheet" type="text/css" href="explore/css/style.css" />
	<body>
		<head>

			<title>Employer</title>

			<meta charset="utf-8" />

			<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

			<meta name="description" content="wijinputdate overview." />

			<meta name="keywords" content="" />

			<meta name="author" content="ComponentOne" />

			<link href="themes/rocket/jquery-wijmo.css" rel="stylesheet" type="text/css" />

			<script src="Wijmo-Complete/development-bundle/external/jquery-1.7.1.min.js" type="text/javascript"></script>

			<script src="Wijmo-Complete/development-bundle/external/jquery-ui-1.8.18.custom.min.js" type="text/javascript"></script>

			<script src="Wijmo-Complete/development-bundle/external/jquery.wijmo-open.all.2.0.8.min.js" type="text/javascript"></script>

			<link href="Wijmo-Complete/development-bundle/themes/wijmo/jquery.wijmo.wijinput.css" rel="stylesheet" type="text/css" />

			<script src="Wijmo-Complete/development-bundle/external/globalize.min.js" type="text/javascript"></script>

			<script src="Wijmo-Complete/development-bundle/external/jquery.mousewheel.min.js" type="text/javascript"></script>

			<script src="Wijmo-Complete/development-bundle/wijmo/jquery.plugin.wijtextselection.js" type="text/javascript"></script>

			<script src="Wijmo-Complete/development-bundle/wijmo/jquery.wijmo.wijinputcore.js" type="text/javascript"></script>

			<script src="Wijmo-Complete/development-bundle/wijmo/jquery.wijmo.wijinputdate.js" type="text/javascript"></script>

			<style type="text/css">
				#textbox3, #textbox4 {

					width: 240px;
				}

			</style>

			<!-- calendar -->
			<script src="Wijmo-Open/development-bundle/wijmo/jquery.wijmo.wijpopup.js" type="text/javascript"></script>
			<script src="Wijmo-Open/development-bundle/wijmo/jquery.wijmo.wijcalendar.js" type="text/javascript"></script>
			<link href="Wijmo-Open/development-bundle/themes/wijmo/jquery.wijmo.wijcalendar.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript">
				$(function() {
					$("#calendar").wijcalendar({
						popupMode : true,
						selectedDatesChanged : function() {
							var selDate = $(this).wijcalendar("getSelectedDate");
							if (!!selDate)
								$("#popdate").val(selDate.toDateString());
						}
					});
					$("#popdate").click(function() {
						$("#calendar").wijcalendar("popup", {
							of : $("#popdate"),
							offset : '0 2'
						});
					})
				});
			</script>
		</head>

		<!-- /calendar -->

		<h1>New employer</h1>

		<form method="post" action="record2db.php">

			<div id="tabs">
				<ul>

					<li>
						<a href="#tabs-pers-data">Personal data</a>
					</li>

					<li>
						<a href="#tabs-biography">Biography</a>
					</li>

				</ul>
				<div id="tabs-pers-data">
					<p>
						<input name="worker_name" id="name" maxlength="50" class="inputbox"
						size="30" value="Name" onblur="if (this.value=='') this.value='Name';" onfocus="if (this.value=='Name') this.value='';" type="text">
					</p>
					<p>
						<input type="text" id="textbox1" value="(xxx) xxx-xxxx"
						onblur="if (this.value=='') this.value='(xxx) xxx-xxxx';" onfocus="if (this.value=='(xxx) xxx-xxxx') this.value='';"/>
					</p>
					<p>
						<div id="calendar">

						</div>

						<label for="popdate">Birth date:</label>

						<input name="popdate" type="text" id="popdate" style="width: 180px;" />
					</p>
				</div>
				<div id="tabs-biography">
					<textarea name = "about_employer" id="wijeditor" style="width: 756px; height: 475px;">
				</textarea>
				</div>
				<input type="submit" value="Send">

			</div>
		</form>
	</body>
	</head>
</html>

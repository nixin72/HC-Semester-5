<?php

	abstract class PEATemplate {
		const HEADER_HOME_KEY = 'home';
		const HEADER_TEAM_KEY = 'team';
		const HEADER_PROJECT_KEY = 'project';
		const HEADER_PRODUCT_KEY = 'product';
		const HEADER_SUPPORT_KEY = 'support';
		const HEADER_CONTACT_KEY = 'contact';
		private $title;
		private $pathToRoot;
		private $headerSection;

		function __construct($pageTitle,$rootPath = './', $highlightHeader = PEATemplate::HEADER_HOME_KEY){
			$this->title = $pageTitle;
			$this->pathToRoot = $rootPath;
			$this->headerSection = $highlightHeader;
		}

		public abstract function createHeader();
		public abstract function createBody();

		public function init(){
			?>
				<!DOCTYPE html>
				<html>
					<head>
						<meta name="theme-color" content="#9a72a1">
						<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, width=device-width, user-scalable=no" />
						<link rel="icon" type="image/png" href="<?php echo $this->pathToRoot ?>favicon.png">
						<title>PEA | <?php print("$this->title"); ?></title>
						<style type="text/css">
							<?php
								require_once "{$this->pathToRoot}lib/lessc.inc";
								$less = new lessc();
								echo str_replace("url('./","url('{$this->pathToRoot}",$less->compileFile("{$this->pathToRoot}styles/template.less"));
							?>
						</style>
						<script src="<?php echo $this->pathToRoot ?>scripts/jquery-3.2.1.min.js">
						</script>

						<?php
							$this->createHeader();
						?>
					</head>
					<body>
						<nav id="nav-bar">
							<header>
								<h2 class='nav-title'>Program Exit Assesment<img src="<?php echo $this->pathToRoot ?>images/logo.png" /></h2>
								<h6>Annonymous Corp., Computer-science, heritage-college, 2017</h6>
							</header>
							<div id="nav-container">
								<ul class="nav-links">
									<a <?php if($this->headerSection == SELF::HEADER_HOME_KEY) {print('class="sectionHighlight"');} ?> href="<?php echo $this->pathToRoot ?>index.php"><li>Home</li></a>
									<li tabindex="0" class="<?php if($this->headerSection == SELF::HEADER_TEAM_KEY) {print('sectionHighlight ');} ?>nav-sub-container" menu="management">The team</li>
									<ul jsenabled="false" menu-container="management" id="nav-sub-menu-management" class="nav-links nav-links-sub">
										<a href="<?php echo $this->pathToRoot ?>us/process.php"><li>How we work</li></a>
										<a href="<?php echo $this->pathToRoot ?>us/team.php"><li>Meet our team</li></a>
										<a href="<?php echo $this->pathToRoot ?>us/management.php"><li>How we manage tings</li></a>
									</ul>
									<li tabindex="0" class="<?php if($this->headerSection == SELF::HEADER_PROJECT_KEY) {print('sectionHighlight ');} ?>nav-sub-container" menu="sdlc">Project status</li>
									<ul jsenabled="false" menu-container="sdlc" id="nav-sub-menu-sdlc" class="nav-links nav-links-sub">
										<a href="<?php echo $this->pathToRoot ?>status/requirements.php"><li>Requirements</li></a>
										<a href="<?php echo $this->pathToRoot ?>status/analysis.php"><li>Analysis</li></a>
										<a href="<?php echo $this->pathToRoot ?>status/design.php"><li>Design</li></a>
										<a href="<?php echo $this->pathToRoot ?>status/implementation.php"><li>Implementation</li></a>
										<a href="<?php echo $this->pathToRoot ?>status/testing.php"><li>Testing</li></a>
									</ul>
									<li tabindex="0" class="<?php if($this->headerSection == SELF::HEADER_PRODUCT_KEY) {print('sectionHighlight ');} ?>nav-sub-container" menu="future">Products</li>
									<ul jsenabled="false" menu-container="future" id="nav-sub-menu-future" class="nav-links nav-links-sub">
										<a href="<?php echo $this->pathToRoot ?>products/deployment.php"><li>Deployment</li></a>
										<a href="<?php echo $this->pathToRoot ?>products/training.php"><li>Training</li></a>
									</ul>
									<a <?php if($this->headerSection == SELF::HEADER_SUPPORT_KEY) {print('class="sectionHighlight"');} ?> href="<?php echo $this->pathToRoot ?>support.php"><li>Support</li></a>
									<a <?php if($this->headerSection == SELF::HEADER_CONTACT_KEY) {print('class="sectionHighlight"');} ?> href="<?php echo $this->pathToRoot ?>contact.php"><li>Contact us</li></a>
								</ul>
							</div>
						</nav>
						<main id="main-content">
							<div id="main-wrapper">
							<?php
								$this->createBody();
							?>

							</div>
							<footer id="main-footer">
								&copy;
								<a href="mailto:Annonymous.Corp@cegep-heritage.qc.ca" target="_blank">Annonymous Corp.</a>,
								<a href="http://www.cegep-heritage.qc.ca/Programs/Computer_Science/index.php" target="_blank">Computer Science</a>,
								<a href="http://www.cegep-heritage.qc.ca" target="_blank">Cegep Heritage College</a>, 2017.<br/>
								All Rights Reserved.
							</footer>
						</main>

						<script src="<?php echo $this->pathToRoot ?>scripts/nav-bar.js">
						</script>

					</body>
				</html>
			<?php
		}
	}
?>

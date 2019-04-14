<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const PAGE_TITLE = 'Analysis';
		const ROOT_PATH = '../';

		function __construct() {
			parent::__construct(PEAPage::PAGE_TITLE,PEAPage::ROOT_PATH,PEATemplate::HEADER_PROJECT_KEY);
		}

		public function createHeader(){
			?>
			<?php
		}

		public function createBody(){
			require_once SELF::ROOT_PATH.'lib/parsedown.inc';
			$md = <<<EOT

# Analysis
Sapien facilisis facilisi platea _volutpat_ sagittis quam conubia condimentum a erat scelerisque tellus a parturient aliquet mi nascetur eu parturient blandit ante viverra feugiat ullamcorper ullamcorper lacinia vestibulum montes. Faucibus hac consequat id id dictum a ligula quis taciti at blandit condimentum sagittis nulla vestibulum. Habitasse augue eleifend lorem vehicula vestibulum integer suspendisse elementum urna aliquet felis adipiscing suspendisse at varius phasellus a quisque elementum eleifend a nec nullam cubilia sagittis consectetur. Adipiscing laoreet vestibulum dignissim a consectetur ad et condimentum ridiculus leo habitasse phasellus a litora mi viverra sem malesuada taciti commodo proin dis suspendisse ut a parturient per. Ultrices class consequat a ac vestibulum sapien vivamus non elementum lacus quisque nibh vehicula vestibulum parturient volutpat nec id a pulvinar a ridiculus maecenas a.

* lorem ipsum
* facilisi platea volutpat
* sagittis quam conubia condimentum

## LOREM IPSUM
Sapien facilisis facilisi platea _**volutpat**_ sagittis quam conubia condimentum a erat scelerisque tellus a parturient aliquet mi nascetur eu parturient blandit ante viverra feugiat ullamcorper ullamcorper lacinia vestibulum montes. Faucibus hac consequat id id dictum a ligula quis taciti at blandit condimentum sagittis nulla vestibulum. Habitasse augue eleifend lorem vehicula vestibulum integer suspendisse elementum urna aliquet felis adipiscing suspendisse at varius phasellus a quisque elementum eleifend a nec nullam cubilia sagittis consectetur. Adipiscing **laoreet** vestibulum dignissim a consectetur ad et condimentum ridiculus leo habitasse phasellus a litora mi viverra sem malesuada taciti commodo proin dis suspendisse ut a parturient per. Ultrices class consequat a ac vestibulum sapien vivamus non elementum lacus quisque nibh vehicula vestibulum parturient volutpat nec id a pulvinar a ridiculus maecenas a.

1. lorem ipsum
2. facilisi platea volutpat
3. sagittis quam conubia condimentum

## LOREM IPSUM

A interdum parturient parturient scelerisque tristique justo a congue dui praesent euismod scelerisque a integer volutpat dui semper litora. Hac ad dictum pharetra scelerisque cubilia hendrerit nullam faucibus nullam a quam adipiscing consectetur a a a sodales amet a hac consectetur lectus taciti vestibulum condimentum vestibulum parturient dis. Dapibus quisque cursus a porta at condimentum ut congue facilisis lacinia felis bibendum amet a curabitur vel consectetur consectetur nibh facilisi porttitor fringilla. Nam tempor purus maecenas convallis integer facilisis a penatibus est in eleifend parturient parturient massa phasellus dis leo suspendisse eros gravida ad.

| header | header2 | header3 |
|:------ |:-------:| -------:|
| left   | center  | right   |
| color2 | color2  | color2  |
| color1 | color1  | color1  |
EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}

	$intro = new PEAPage();
	$intro->init();
?>

<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const PAGE_TITLE = 'Implementation';
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
# Implementation
* Sapien facilisis facilisi platea volutpat sagittis quam conubia condimentum a erat scelerisque tellus a parturient aliquet mi nascetur eu parturient blandit ante viverra feugiat ullamcorper ullamcorper lacinia vestibulum montes. Faucibus hac consequat id id dictum a ligula quis taciti at blandit condimentum sagittis nulla vestibulum. Habitasse augue eleifend lorem vehicula vestibulum integer suspendisse elementum urna aliquet felis adipiscing suspendisse at varius phasellus a quisque elementum eleifend a nec nullam cubilia sagittis consectetur. Adipiscing laoreet vestibulum dignissim a consectetur ad et condimentum ridiculus leo habitasse phasellus a litora mi viverra sem malesuada taciti commodo proin dis suspendisse ut a parturient per. Ultrices class consequat a ac vestibulum sapien vivamus non elementum lacus quisque nibh vehicula vestibulum parturient volutpat nec id a pulvinar a ridiculus maecenas a.
  * gak
      * gak
          * gak

1. Sapien facilisis facilisi platea volutpat sagittis quam conubia condimentum a erat scelerisque tellus a parturient aliquet mi nascetur eu parturient blandit ante viverra feugiat ullamcorper ullamcorper lacinia vestibulum montes. Faucibus hac consequat id id dictum a ligula quis taciti at blandit condimentum sagittis nulla vestibulum. Habitasse augue eleifend lorem vehicula vestibulum integer suspendisse elementum urna aliquet felis adipiscing suspendisse at varius phasellus a quisque elementum eleifend a nec nullam cubilia sagittis consectetur. Adipiscing laoreet vestibulum dignissim a consectetur ad et condimentum ridiculus leo habitasse phasellus a litora mi viverra sem malesuada taciti commodo proin dis suspendisse ut a parturient per. Ultrices class consequat a ac vestibulum sapien vivamus non elementum lacus quisque nibh vehicula vestibulum parturient volutpat nec id a pulvinar a ridiculus maecenas a.
  1. gak
      1. gak
          1. gak
EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}

	$intro = new PEAPage();
	$intro->init();
?>

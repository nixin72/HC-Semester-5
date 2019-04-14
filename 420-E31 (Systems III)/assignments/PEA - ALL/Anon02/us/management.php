<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const PAGE_TITLE = 'Management';
		const ROOT_PATH = '../';

		function __construct() {
			parent::__construct(PEAPage::PAGE_TITLE,PEAPage::ROOT_PATH,PEATemplate::HEADER_TEAM_KEY);
		}

		public function createHeader(){
			?>
			<?php
		}

		public function createBody(){
			require_once SELF::ROOT_PATH.'lib/parsedown.inc';
			$md = <<<EOT
# Project Management
Mi adipiscing arcu lacinia hendrerit commodo platea laoreet at turpis consectetur lacus pretium integer nisl ullamcorper posuere a adipiscing id taciti parturient molestie. Malesuada consequat primis auctor neque nibh feugiat hac dignissim laoreet laoreet maecenas lectus donec vestibulum commodo dictumst quam. Turpis semper ullamcorper vehicula orci habitasse lectus vehicula ultrices mus morbi commodo ac iaculis lorem suspendisse. Adipiscing euismod aliquam faucibus a leo torquent vestibulum suspendisse fringilla libero eu nostra tempus duis a sodales vestibulum commodo sit cursus condimentum a parturient. Vulputate ac a a cum rhoncus sed velit nibh a ullamcorper per a at libero vitae fringilla urna vestibulum neque sem convallis consectetur elementum mollis et lorem.

EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}

	$intro = new PEAPage();
	$intro->init();
?>

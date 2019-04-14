<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const PAGE_TITLE = 'Testing';
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
# Testing
A scelerisque arcu Leo non aliquam ornare non habitant suspendisse parturient integer arcu nascetur duis eleifend vestibulum ad orci.

Commodo a odio nulla mattis in  ornare amt torquent erat adipiscing eu quisque fusce dui adipiscing scelerisque imperdiet elit interdum adipiscing adipiscing tellus.

Sodales dis nec id tellus suspendisse mi vinar odio sed in habitasse venenatis. Id lacinia a consectetur quisque consectetur iaculis justo at id magnis a nisi aliquam faucibus suspendisse.

A interdum partur a penatibus est in dis leo suspendisse eros gravida ad.

Sapien consectetur nisl adipiscing tumst  Vehicula porttitor et conubia hendrerit magnis montes viverra consectetur vestibulum facilisis parturient nascetur ligula aliquam scelerisque fringilla facilisi suscipit pretium a at dis consectetur mus odio vestibulum.

Felis parturient habitant scelerisqueinceptos  congue turpis.

Habitasse vestibulum at velum ad sit suspendisse condimentum penatibus ante donec tellus quis quisque.

A sodales ullamcorper senectus amet a dolor id tortor parturient cras a nibh dis at. Lacus ut ultricies  dictum netus.
EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}

	$intro = new PEAPage();
	$intro->init();
?>

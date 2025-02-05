<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const PAGE_TITLE = 'Design';
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
# Design
Sapien facilisis facilisi platea volutpat sagittis quam conubia condimentum a erat scelerisque tellus a parturient aliquet mi nascetur eu parturient blandit ante viverra feugiat ullamcorper ullamcorper lacinia vestibulum montes. Faucibus hac consequat id id dictum a ligula quis taciti at blandit condimentum sagittis nulla vestibulum. Habitasse augue eleifend lorem vehicula vestibulum integer suspendisse elementum urna aliquet felis adipiscing suspendisse at varius phasellus a quisque elementum eleifend a nec nullam cubilia sagittis consectetur. Adipiscing laoreet vestibulum dignissim a consectetur ad et condimentum ridiculus leo habitasse phasellus a litora mi viverra sem malesuada taciti commodo proin dis suspendisse ut a parturient per. Ultrices class consequat a ac vestibulum sapien vivamus non elementum lacus quisque nibh vehicula vestibulum parturient volutpat nec id a pulvinar a ridiculus maecenas a.

A scelerisque arcu ultrices a vel mi enim eleifend mollis felis magnis condimentum parturient vitae montes scelerisque a cum faucibus a penatibus donec integer ullamcorper. Venenatis id condimentum sociis volutpat ad eros condimentum eleifend leo a ut consectetur orci adipiscing arcu nisi posuere conubia porttitor vestibulum sit nascetur. Id imperdiet duis adipiscing habitasse vehicula parturient habitasse a condimentum per aliquam vivamus euismod adipiscing inceptos hac mauris duis penatibus sit venenatis ut. Leo non aliquam etiam velit parturient at maecenas condimentum a lorem scelerisque massa torquent orci elit etiam mi lacinia parturient vestibulum a non quisque. Leo tristique ullamcorper sodales mattis parturient non vestibulum vestibulum neque nisi hac non ullamcorper natoque id scelerisque vestibulum adipiscing posuere. Nec ullamcorper at vivamus nulla condimentum id ornare ornare non habitant suspendisse parturient integer arcu nascetur duis eleifend vestibulum ad orci.

Commodo a odio nulla mattis in adipiscing ornare cras scelerisque condimentum vulputate condimentum metus taciti enim. Parturient nibh mauris scelerisque ullamcorper netus primis at nostra vestibulum adipiscing metus cum adipiscing dignissim vestibulum accumsan ac taciti convallis ac. Conubia cum sit suspendisse parturient adipiscing hendrerit eleifend congue quis a adipiscing sagittis parturient a at ut penatibus. Quam a suspendisse lobortis rhoncus at sodales eleifend hendrerit at ut est tellus a id a bibendum consectetur condimentum consequat. Leo a ullamcorper scelerisque cum rhoncus nam suspendisse dui eu fermentum vestibulum malesuada potenti rutrum sed mus ultricies est. Libero laoreet sem ad accumsan eget torquent erat adipiscing eu quisque fusce dui adipiscing scelerisque imperdiet elit interdum adipiscing adipiscing tellus.

Sodales dis nec id tellus suspendisse mi vitae parturient facilisi gravida varius fermentum a dignissim sagittis a a. Scelerisque suspendisse ut molestie fames a consequat a natoque ad condimentum donec convallis vehicula integer condimentum sociis leo dictum vestibulum at a felis sed adipiscing sociosqu et in inceptos. Vulputate pulvinar rutrum quam faucibus dolor cum facilisi donec scelerisque sit et libero a aliquam morbi dolor arcu justo. Blandit scelerisque a rhoncus neque enim mauris quis enim a enim eu interdum nibh sed mattis pulvinar odio sed in habitasse venenatis. Id lacinia a consectetur quisque consectetur iaculis justo at id magnis a nisi aliquam faucibus suspendisse.

A interdum parturient parturient scelerisque tristique justo a congue dui praesent euismod scelerisque a integer volutpat dui semper litora. Hac ad dictum pharetra scelerisque cubilia hendrerit nullam faucibus nullam a quam adipiscing consectetur a a a sodales amet a hac consectetur lectus taciti vestibulum condimentum vestibulum parturient dis. Dapibus quisque cursus a porta at condimentum ut congue facilisis lacinia felis bibendum amet a curabitur vel consectetur consectetur nibh facilisi porttitor fringilla. Nam tempor purus maecenas convallis integer facilisis a penatibus est in eleifend parturient parturient massa phasellus dis leo suspendisse eros gravida ad.

Sapien consectetur nisl adipiscing at adipiscing sem vestibulum mauris nostra nunc ultrices a ipsum consectetur habitasse nec nam platea lacus quam neque suspendisse. Magnis scelerisque felis augue parturient neque parturient etiam et nam adipiscing nec nibh torquent rhoncus malesuada feugiat fusce blandit parturient pulvinar blandit in netus a arcu. Dictumst maecenas placerat eros etiam praesent dapibus risus senectus integer enim a at parturient a facilisis curae phasellus parturient condimentum. Sagittis ultricies nibh a nascetur interdum dis nec a nunc erat dictum dictumst molestie primis sodales molestie ut tortor. Vehicula porttitor et conubia hendrerit magnis montes viverra consectetur vestibulum facilisis parturient nascetur ligula aliquam scelerisque fringilla facilisi suscipit pretium a at dis consectetur mus odio vestibulum.
EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}

	$intro = new PEAPage();
	$intro->init();
?>

<?php
	require './lib/template.inc';
	class PEAPage extends PEATemplate {
		const PAGE_TITLE = 'Support';
		const ROOT_PATH = './';
		function __construct() {
			parent::__construct(PEAPage::PAGE_TITLE, PEAPage::ROOT_PATH, PEATemplate::HEADER_SUPPORT_KEY);
		}
		public function createHeader(){
			?>
			<?php
		}
		public function createBody(){
			require_once SELF::ROOT_PATH.'lib/parsedown.inc';
			$md = <<<EOT
# Maintnance
A placerat hac ac scelerisque himenaeos [ipsum](./index.php) diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

## Lorem Ipsum
A placerat hac ac scelerisque himenaeos [ipsum](./index.php) diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

### Lorem Ipsum
A commodo mollis consectetur suspendisse penatibus non augue ultrices consectetur maecenas scelerisque adipiscing magna morbi mauris enim dui vestibulum tortor ad penatibus etiam nisl. Parturient ut ad nostra quam id a turpis auctor condimentum a nunc metus cras facilisi adipiscing aliquam lorem vestibulum convallis volutpat torquent massa adipiscing adipiscing luctus neque risus. Bibendum condimentum erat consectetur mollis lorem rutrum netus auctor sem id parturient eu a parturient suspendisse tortor quisque a egestas iaculis id a. A dictum convallis sem a vestibulum himenaeos vitae massa adipiscing consequat habitant nisl litora aliquam morbi maecenas per a sed id ac libero auctor auctor erat in.

#### Lorem Ipsum
Congue aliquet vulputate condimentum a libero aptent eget suspendisse eros a enim lectus vitae sed sodales vestibulum condimentum potenti praesent condimentum tempor. Scelerisque euismod ante est class semper consectetur vestibulum elementum a nisl mauris ullamcorper tempor sodales. Gravida suspendisse a velit mus imperdiet suspendisse conubia amet consectetur ridiculus parturient vitae sagittis ac. Aenean ipsum est consectetur turpis suscipit morbi eu massa cras donec fermentum sed a consectetur. Nam ipsum parturient urna lacus laoreet a suspendisse non adipiscing in id montes dolor euismod facilisi aliquet consectetur posuere.

##### Lorem Ipsum
Congue aliquet vulputate condimentum a libero aptent eget suspendisse eros a enim lectus vitae sed sodales vestibulum condimentum potenti praesent condimentum tempor. Scelerisque euismod ante est class semper consectetur vestibulum elementum a nisl mauris ullamcorper tempor sodales. Gravida suspendisse a velit mus imperdiet suspendisse conubia amet consectetur ridiculus parturient vitae sagittis ac. Aenean ipsum est consectetur turpis suscipit morbi eu massa cras donec fermentum sed a consectetur. Nam ipsum parturient urna lacus laoreet a suspendisse non adipiscing in id montes dolor euismod facilisi aliquet consectetur posuere.

###### Lorem Ipsum
Congue aliquet vulputate condimentum a libero aptent eget suspendisse eros a enim lectus vitae sed sodales vestibulum condimentum potenti praesent condimentum tempor. Scelerisque euismod ante est class semper consectetur vestibulum elementum a nisl mauris ullamcorper tempor sodales. Gravida suspendisse a velit mus imperdiet suspendisse conubia amet consectetur ridiculus parturient vitae sagittis ac. Aenean ipsum est consectetur turpis suscipit morbi eu massa cras donec fermentum sed a consectetur. Nam ipsum parturient urna lacus laoreet a suspendisse non adipiscing in id montes dolor euismod facilisi aliquet consectetur posuere.
EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}
	$intro = new PEAPage();
	$intro->init();
?>

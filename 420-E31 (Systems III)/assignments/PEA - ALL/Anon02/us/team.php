<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {
		const ROOT_PATH = '../';
		const PAGE_TITLE = 'Meet the team';
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
# Team Environnement
A placerat hac ac scelerisque himenaeos ipsum diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

---

# Lorem Ipsum
A placerat hac ac scelerisque himenaeos ipsum diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

---

# Lorem Ipsum
A placerat hac ac scelerisque himenaeos ipsum diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

---

# Lorem Ipsum
A placerat hac ac scelerisque himenaeos ipsum diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

---

# Lorem Ipsum
A placerat hac ac scelerisque himenaeos ipsum diam viverra feugiat ad nulla eleifend duis a suspendisse adipiscing est morbi mauris nulla netus. Lectus suspendisse mus parturient vestibulum faucibus ultricies parturient posuere parturient phasellus aliquet tellus sociis venenatis maecenas fusce a duis malesuada condimentum vestibulum nec erat nunc. A suspendisse scelerisque parturient ante sociis vestibulum commodo eu taciti blandit metus ad a vestibulum elit lacinia id nascetur ac a convallis hac maecenas. Ac cursus parturient platea ullamcorper est nostra quis felis convallis adipiscing sed at vestibulum a a a conubia nisi faucibus est eget mollis viverra. Auctor quisque ullamcorper iaculis gravida felis vitae mollis semper congue malesuada nisi natoque etiam sed rhoncus ad mus tincidunt accumsan urna porta.

EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}
	$intro = new PEAPage();
	$intro->init();
?>

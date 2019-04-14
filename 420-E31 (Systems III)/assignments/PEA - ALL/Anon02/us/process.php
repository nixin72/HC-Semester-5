<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const ROOT_PATH = '../';
		const PAGE_TITLE = 'Work Process';

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
# Work Process
Mi adipiscing arcu lacinia hendrerit commodo platea laoreet at turpis consectetur lacus pretium integer nisl ullamcorper posuere a adipiscing id taciti parturient molestie. Malesuada consequat primis auctor neque nibh feugiat hac dignissim laoreet laoreet maecenas lectus donec vestibulum commodo dictumst quam. Turpis semper ullamcorper vehicula orci habitasse lectus vehicula ultrices mus morbi commodo ac iaculis lorem suspendisse. Adipiscing euismod aliquam faucibus a leo torquent vestibulum suspendisse fringilla libero eu nostra tempus duis a sodales vestibulum commodo sit cursus condimentum a parturient. Vulputate ac a a cum rhoncus sed velit nibh a ullamcorper per a at libero vitae fringilla urna vestibulum neque sem convallis consectetur elementum mollis et lorem.

Parturient at a id erat suspendisse eros diam eget vivamus a facilisi imperdiet neque purus consectetur. A parturient ante sit vestibulum aliquam sociosqu consectetur eget eu magna suspendisse nec duis suscipit mi parturient felis suspendisse orci vestibulum facilisi suspendisse scelerisque adipiscing pulvinar consectetur placerat. Elementum dolor scelerisque vitae vulputate nam cubilia vivamus vestibulum a consectetur interdum suspendisse et dis egestas nullam.

Conubia arcu et nec dictum in a scelerisque potenti venenatis proin et ac imperdiet eu ac fringilla parturient luctus scelerisque hac. Adipiscing vestibulum euismod potenti accumsan a dapibus suspendisse litora elit parturient lectus ullamcorper eros platea ante. Justo ullamcorper parturient lacus dictum natoque consectetur ac parturient torquent orci a cras at adipiscing fringilla lorem. Convallis phasellus vestibulum parturient vestibulum neque adipiscing eu eu ad natoque cum eget faucibus vestibulum nunc phasellus a.

Imperdiet litora vestibulum montes a et ultrices senectus netus ut fames mus maecenas penatibus nostra fringilla diam diam quam facilisi quam enim parturient. Mi et taciti viverra vestibulum turpis nisl parturient in suspendisse a pretium integer eleifend porttitor adipiscing taciti per cum a faucibus cum egestas parturient nec cras. At facilisis natoque vitae elementum scelerisque consectetur sociis a tincidunt porta natoque dis ullamcorper at volutpat nisi mattis condimentum sed mi. Condimentum scelerisque mi a rutrum volutpat neque commodo ad parturient ullamcorper vestibulum primis nec suspendisse fusce curabitur praesent etiam dis malesuada varius. Dictumst vehicula a et venenatis ullamcorper vestibulum integer sed pulvinar massa hendrerit nunc velit a vehicula.

Commodo penatibus a praesent vestibulum adipiscing proin tristique mi eget sodales parturient ullamcorper etiam suspendisse mollis dapibus a eu pulvinar adipiscing cursus laoreet sem. Habitant lorem consectetur nostra nisi consectetur nisi cubilia in netus habitasse consectetur sed et adipiscing curabitur varius et. Vestibulum aliquam mus ullamcorper a et bibendum cras a imperdiet id erat in etiam nisi cras a faucibus nec ridiculus amet.

Nec arcu pretium cras a luctus tempor parturient interdum nostra aliquam cras auctor vel magnis consequat placerat congue. Sociosqu ullamcorper hac nam velit a phasellus parturient phasellus sociosqu a pharetra habitasse suspendisse a eros accumsan etiam duis parturient tellus. Vestibulum ad a dui dapibus dui cras commodo molestie varius scelerisque condimentum fames sociis ullamcorper porta a massa. A interdum parturient ut urna a tortor nunc ullamcorper at laoreet natoque ad dignissim adipiscing vestibulum amet congue maecenas egestas netus a parturient massa litora curabitur. A venenatis netus a scelerisque semper nunc eu parturient phasellus a enim a leo parturient in in justo purus congue parturient id a.

Adipiscing a at vestibulum scelerisque cubilia conubia parturient a ad malesuada per est maecenas nullam consectetur. Etiam hendrerit parturient libero taciti ut condimentum magna habitant parturient parturient mi a a libero. Habitant in nec curae magna et a ultricies bibendum est ullamcorper vulputate a adipiscing urna scelerisque ad in per a erat nunc sagittis conubia ipsum sociosqu tempor dictum.

Bibendum per interdum luctus suspendisse quam tincidunt convallis orci rhoncus at vivamus condimentum suspendisse mollis fringilla parturient a venenatis ante tortor purus in molestie. In mus phasellus parturient fringilla vivamus dis sagittis sagittis at quam fermentum a integer tincidunt at in nullam. Iaculis condimentum tempus scelerisque ullamcorper morbi dictumst consequat vestibulum tempor interdum conubia morbi vestibulum suspendisse a senectus inceptos at ad fermentum enim fusce platea leo a.

Suspendisse at curabitur facilisis a velit cras interdum orci felis elit id habitant diam est habitant est fermentum eget vestibulum. Ante non quam arcu per eros ridiculus a a sagittis facilisis sed sit pretium a elementum tortor odio ullamcorper venenatis hac a a parturient nam. Hac venenatis vel varius varius at sagittis habitasse odio curabitur a sem dis consequat in cras id curabitur a in dui purus non inceptos elementum a mi a.

Vel taciti consectetur leo malesuada ipsum suspendisse neque penatibus conubia placerat adipiscing cubilia adipiscing quam porta suspendisse. Suspendisse conubia mus quam parturient a nam curabitur fringilla consectetur gravida primis a dis vel ad in ullamcorper cubilia ante phasellus. Leo quis nisi euismod duis habitasse non a class mi gravida non a condimentum a adipiscing a est sapien lectus nisi senectus.

Nisi leo senectus condimentum erat cras tortor a hac ante purus parturient nulla ad pulvinar tellus bibendum non a consequat. Quisque sem eu a parturient fringilla feugiat metus senectus a eros a elementum in mi magnis mus a duis viverra tellus adipiscing. Viverra mus enim facilisis varius vel commodo habitasse a facilisi a a dolor dictum porttitor leo mus natoque in felis in dictumst praesent scelerisque nam euismod nisi. Euismod augue eu ante vestibulum ante a vel duis lacinia dui adipiscing magna egestas ad sociis semper scelerisque vestibulum a ut magna nostra egestas cubilia vulputate adipiscing eleifend.

Porttitor nibh vivamus volutpat laoreet vestibulum lacus eget consectetur a himenaeos vivamus ridiculus a nisl potenti inceptos. Blandit fringilla suspendisse dis suspendisse pulvinar pulvinar id vestibulum parturient et suspendisse congue a penatibus arcu feugiat fames tellus suspendisse volutpat tempus bibendum massa massa a. Nam porttitor posuere hac feugiat eu purus per ad laoreet a sodales nisi malesuada condimentum. Imperdiet ultrices sagittis cras at natoque porttitor himenaeos ac aliquet a felis commodo odio libero aenean a condimentum sed a cubilia amet. Dictum a et parturient ullamcorper adipiscing parturient scelerisque pretium adipiscing a lorem sit adipiscing aliquam facilisi inceptos a at.

Non bibendum conubia a a fringilla scelerisque litora primis conubia id nam adipiscing a phasellus rutrum a aliquam. Vestibulum vitae vestibulum euismod a penatibus gravida facilisis enim scelerisque vestibulum ac nisl parturient torquent laoreet massa parturient at mus. Maecenas porta adipiscing adipiscing adipiscing a curae sit a parturient conubia sociosqu a vestibulum ullamcorper dapibus curae urna adipiscing taciti nostra sapien.

EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}
	$intro = new PEAPage();
	$intro->init();
?>

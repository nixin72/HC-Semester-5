<?php
	require '../lib/template.inc';
	class PEAPage extends PEATemplate {

		const PAGE_TITLE = 'Products';
		const ROOT_PATH = '../';

		function __construct() {
			parent::__construct(PEAPage::PAGE_TITLE,PEAPage::ROOT_PATH,PEATemplate::HEADER_PRODUCT_KEY);
		}

		public function createHeader(){
			?>
			<?php
		}

		public function createBody(){
			require_once SELF::ROOT_PATH.'lib/parsedown.inc';
			$md = <<<EOT
# Deployment
Consectetur vehicula neque diam ultrices ad nibh a elit vehicula ac porttitor phasellus elementum scelerisque ullamcorper id praesent nullam cum. Enim nisl vestibulum a sit sodales id commodo magnis sociosqu urna lacus pharetra a consequat mus consectetur a a cum condimentum vulputate a a a. Tincidunt a condimentum scelerisque vulputate ullamcorper lobortis a habitasse a id augue a diam parturient tempus. Malesuada iaculis a porta posuere dis ac dignissim ligula a euismod donec egestas nisl habitant primis. Vestibulum a sapien commodo a blandit himenaeos et placerat adipiscing integer vestibulum convallis parturient adipiscing dignissim amet a posuere donec quisque adipiscing eu ante habitasse elit. In convallis taciti ac euismod aliquam eu lacus neque pharetra dolor hac mi suspendisse metus interdum sociosqu vestibulum ultricies dictumst a. Adipiscing a adipiscing et commodo a ornare iaculis suspendisse enim condimentum blandit per litora pretium pulvinar a mi erat a parturient hendrerit praesent pharetra parturient ultricies maecenas commodo condimentum.

A a egestas mattis penatibus parturient curae mauris in per himenaeos tellus a mus sagittis massa parturient tincidunt erat bibendum fermentum consectetur. Ullamcorper etiam cras accumsan ut vestibulum integer in risus tristique luctus dapibus ut rhoncus a a potenti id felis id lacus purus varius tempor commodo. Vitae a odio aliquam a condimentum duis mi orci vestibulum cum nullam in condimentum et condimentum aenean aptent habitasse sem donec elit nulla mus adipiscing. Scelerisque curae mus adipiscing a hendrerit cursus vestibulum scelerisque a posuere vestibulum class convallis lobortis enim placerat inceptos adipiscing accumsan a. Fames blandit diam ac condimentum est a praesent primis vel gravida vestibulum duis tortor elit consectetur sit eget id luctus.

Parturient eget a congue adipiscing conubia nisi senectus sem in elementum a rhoncus est suspendisse per dapibus a odio a suscipit vestibulum conubia eu ante et a ac nulla. Per felis curabitur feugiat faucibus pretium lectus quis suspendisse a adipiscing eu imperdiet mi cubilia vel vestibulum pulvinar ligula commodo amet habitasse sapien. Ullamcorper vivamus varius a dolor neque eros parturient dui purus sem nibh mi class adipiscing condimentum velit lorem maecenas aliquam.

# Lorem Ipsum
Vulputate malesuada pulvinar erat hac hendrerit ridiculus adipiscing ullamcorper vestibulum nisl a vestibulum a id condimentum semper nascetur. Vestibulum mi lobortis ut est odio faucibus hendrerit egestas nascetur eu fames parturient vulputate parturient dis tempus amet vestibulum sed a ut sociis convallis donec. Suspendisse suspendisse felis ornare nibh nunc a at vestibulum erat a netus vestibulum enim conubia parturient mauris id. Aenean at arcu mauris consectetur arcu ridiculus quis suspendisse dapibus egestas a condimentum volutpat a sociis rhoncus a hac lorem vestibulum inceptos vestibulum. Leo volutpat duis himenaeos mi mi parturient a a vulputate suspendisse a turpis vulputate porta tellus orci vehicula nascetur nostra id.

Ad vestibulum class condimentum ullamcorper sed praesent quam a dui penatibus condimentum a et parturient ac a ultricies quis blandit condimentum vestibulum vestibulum elementum placerat tincidunt non dis est. Suspendisse donec a massa facilisis tempor a netus odio condimentum varius vestibulum a erat donec dui taciti fames cum aliquet aenean purus a praesent vitae a. Justo in etiam malesuada a nascetur a a torquent himenaeos suspendisse neque imperdiet a nec conubia malesuada. Feugiat suspendisse commodo in a cubilia ad in parturient felis dapibus ullamcorper sem nascetur ullamcorper platea dis id parturient eu. Sociis egestas adipiscing erat rhoncus pharetra enim nec odio a posuere lobortis potenti tristique justo at.

Fames integer amet sem interdum ullamcorper adipiscing proin ridiculus cubilia nascetur et egestas a parturient a quisque natoque. Ac nam dignissim cras a malesuada semper vehicula faucibus in adipiscing cubilia aptent posuere praesent imperdiet erat senectus ad a sapien penatibus. A vulputate parturient gravida consectetur taciti scelerisque vivamus consectetur vivamus class a a vulputate scelerisque orci odio cras vestibulum adipiscing.

Facilisis vivamus vestibulum posuere mi interdum lectus nisl nulla lobortis parturient bibendum a velit hac. A faucibus erat ultrices a parturient ad egestas adipiscing vestibulum maecenas facilisis ligula est blandit in ut a ullamcorper a. Aliquet vestibulum a ullamcorper faucibus quisque condimentum ullamcorper suspendisse dui arcu nam luctus vestibulum leo facilisis vestibulum condimentum dui vulputate volutpat. Donec ut adipiscing interdum condimentum habitasse proin eget facilisis sit enim integer varius at praesent parturient a consectetur neque porta platea parturient ac. Consequat aptent fringilla congue suscipit parturient a placerat ullamcorper vel a tempus diam taciti arcu ullamcorper netus scelerisque. Primis ullamcorper ad in in mattis consequat consequat praesent nibh ligula hac volutpat bibendum sapien praesent massa commodo justo natoque a adipiscing parturient urna parturient cum ac.

Ultricies mattis cum id ipsum donec augue porttitor scelerisque mus posuere libero vestibulum ullamcorper volutpat scelerisque a gravida aptent arcu parturient consequat suspendisse quisque porttitor. Curae hac id ullamcorper in nullam adipiscing adipiscing ac quisque cum accumsan dictum auctor ultrices cubilia non a at ante ac cras rhoncus a tristique. Class lobortis magnis lorem placerat morbi inceptos ultrices ad id id arcu luctus inceptos sociosqu per a a tincidunt. Tristique id scelerisque lacinia hendrerit consequat a vestibulum egestas vestibulum parturient sit scelerisque a at. Bibendum mi sit ridiculus suscipit iaculis tristique a vestibulum orci condimentum torquent orci inceptos a a. Mus senectus nibh a ultricies vestibulum habitant habitasse adipiscing risus netus hac nunc imperdiet a at adipiscing gravida lacus arcu leo augue nam arcu ridiculus.

# Lorem Ipsum
Suspendisse urna morbi tortor hendrerit id leo a nostra vitae montes penatibus dapibus parturient nulla conubia libero tellus mi vestibulum vehicula pulvinar a ligula est viverra accumsan. Nullam semper phasellus odio purus parturient fusce metus dictum congue phasellus sed nascetur hendrerit fusce sociis hac pulvinar. Cum phasellus non sodales quam porttitor enim lacinia mi suspendisse arcu lacinia ac rutrum vitae in ad. A porta condimentum adipiscing parturient cubilia natoque a sed parturient eros ultrices a placerat fringilla venenatis a cum a lacinia eu. Turpis dignissim interdum vestibulum laoreet urna tincidunt vestibulum vel vestibulum curae vulputate praesent nam vehicula in aliquam a et erat tempus adipiscing. Velit a a ad in diam penatibus blandit parturient magna leo gravida parturient himenaeos magnis ligula ullamcorper adipiscing consectetur ornare ultrices torquent a ridiculus laoreet magnis.

Tempus sem eu est nam vestibulum platea tempor condimentum litora nibh fermentum ad porttitor a consectetur laoreet turpis a dolor consectetur posuere curae. Scelerisque vestibulum dis ac nam volutpat ullamcorper suspendisse a adipiscing nascetur ridiculus suspendisse fames a. Ullamcorper sodales ullamcorper nam consectetur sem adipiscing penatibus felis natoque per dignissim scelerisque tincidunt etiam id mus maecenas aliquet pharetra consectetur torquent elementum eros. Suspendisse adipiscing luctus condimentum nulla ullamcorper a vestibulum sociosqu metus a consectetur turpis aliquam purus. Etiam nunc ut adipiscing penatibus mi nibh vestibulum adipiscing cubilia tempor fermentum cras iaculis fusce ultricies pulvinar vestibulum mus consectetur praesent. A a ad fermentum vestibulum nibh parturient scelerisque parturient facilisis euismod a a suspendisse justo suspendisse phasellus facilisis tempor vestibulum laoreet auctor adipiscing.

A mattis enim a parturient iaculis gravida scelerisque diam rhoncus placerat a a adipiscing scelerisque scelerisque lacus a pulvinar dui cursus vestibulum. Mus lacus himenaeos vehicula dui ad montes at tellus himenaeos a a suspendisse lobortis leo auctor urna ut consectetur. Non vulputate elit parturient pulvinar lacus sagittis mattis scelerisque nisi a ullamcorper est vestibulum magnis facilisis a litora cum.

Vestibulum a in posuere metus et vestibulum enim cum ad a in senectus a pharetra vestibulum vulputate. Vivamus urna a suspendisse dui imperdiet suspendisse a parturient parturient vehicula a proin diam malesuada quam sed sodales rutrum suspendisse hendrerit scelerisque facilisi cursus scelerisque adipiscing eget a vel. Facilisis a tristique orci ad lobortis parturient eu ac condimentum parturient fringilla facilisi diam sem ornare torquent in eros.

# Lorem Ipsum
Lacinia fusce a mus mi metus scelerisque morbi commodo consectetur mi at dictumst suspendisse odio parturient consectetur id a parturient venenatis maecenas vestibulum. Fames a habitasse lacinia dis himenaeos posuere non quam nisi mauris sem eget quisque erat elit blandit cras diam. Sociosqu a a aliquam integer at placerat condimentum in proin a curabitur scelerisque cum rutrum a dignissim scelerisque magnis duis parturient ante fringilla. Mi pharetra platea facilisis egestas potenti parturient nam vestibulum a parturient parturient ullamcorper tempor curae vel integer maecenas consectetur sem. Consectetur consectetur quis tempus curabitur habitasse nunc suscipit a leo vestibulum mus nascetur scelerisque a vehicula non velit penatibus a a eu.

Adipiscing nullam montes scelerisque fermentum orci scelerisque cubilia vestibulum potenti auctor mi egestas facilisi cursus a accumsan pulvinar facilisis. Cum leo varius rhoncus non a nascetur a ullamcorper congue rhoncus viverra duis consectetur consectetur pulvinar conubia parturient blandit purus tellus interdum diam condimentum vestibulum condimentum. A sem adipiscing curabitur laoreet platea vestibulum risus a odio bibendum felis sociis nam aptent nullam et a adipiscing convallis consectetur.

Ipsum faucibus tincidunt magnis eget posuere ultricies commodo enim platea vulputate libero vitae scelerisque felis a lectus congue. Dignissim rutrum id massa a donec porttitor class scelerisque dapibus dignissim habitasse est ut hendrerit nec magna in libero. Luctus ante eu vivamus a a mi ut nam vestibulum suspendisse cras id est ullamcorper amet nisl. Etiam primis sem lectus sociosqu a donec a commodo sed neque class pretium sociis nostra sed lobortis ad et et dis parturient vestibulum a nulla adipiscing nibh. Cras arcu pharetra condimentum consectetur pulvinar dis vestibulum venenatis est phasellus elit a tempor scelerisque tincidunt feugiat a duis.

Metus parturient fringilla elit adipiscing praesent hac tincidunt habitasse litora vel a condimentum pulvinar parturient ipsum mi ac condimentum netus et curabitur. Dis nunc tincidunt suspendisse facilisi a mus ac iaculis parturient ullamcorper vel suspendisse arcu aliquam scelerisque consectetur eleifend nec. Odio mollis proin leo mi est hac magnis suspendisse praesent dictumst rhoncus adipiscing placerat a metus augue ridiculus potenti. A aliquam a habitasse donec mi a fringilla nam fringilla iaculis vestibulum feugiat nibh a proin eleifend. Posuere metus ridiculus scelerisque aptent egestas porta vehicula fringilla suspendisse accumsan dignissim massa vivamus placerat a augue arcu nisl lobortis a ligula sed.
EOT;
			$parser = new Parsedown();
			echo $parser->text($md);
		}
	}

	$intro = new PEAPage();
	$intro->init();
?>

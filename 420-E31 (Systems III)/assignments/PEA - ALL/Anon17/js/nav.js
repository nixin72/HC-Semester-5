var nav = `
    <div class="w3-row w3-content w3-center">
    
        <div class="w3-bar w3-light-grey w3-round w3-hide-small">
            <div id="Dummy" class="hidden">
            <button class="w3-bar-item w3-button"></button>
            </div>
            <!-- Home Page -->
            <div class="w3-dropdown-hover">
                <button class="w3-button">Home Page</button>
                <div class="w3-dropdown-content w3-bar-block w3-border">
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Introduction')">Introduction</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('PEAProject')">PEA Project</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('AppliedExperience')">Applied Experience</button>
                </div>
            </div>
            
            <!-- Initiation -->
            <div class="w3-dropdown-hover">
                <button class="w3-button">Initiation</button>
                <div class="w3-dropdown-content w3-bar-block w3-border">
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Process')">Process</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('TeamEnvironment')">Team Environment</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('ProjectManagement')">Project Management</button>
                </div>
            </div>
            
            <!-- Construction -->
            <div class="w3-dropdown-hover">
                <button class="w3-button">Construction</button>
                <div class="w3-dropdown-content w3-bar-block w3-border">
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Requirements')">Requirements</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Analysis')">Analysis</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Design')">Design</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Implementation')">Implementation</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Test')">Test</button>
                </div>
            </div>
            
            <!-- Release -->
            <div class="w3-dropdown-hover">
                <button class="w3-button">Release</button>
                <div class="w3-dropdown-content w3-bar-block w3-border">
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Deployment')">Deployment</button>
                    <button class="w3-bar-item w3-button" onclick="ChangeContent('Training')">Training</button>
                </div>
            </div>
            
            <button class="w3-bar-item w3-button" onclick="ChangeContent('Maintenance')">Maintenance</button>
            <button class="w3-bar-item w3-button" onclick="ChangeContent('Communications')">Communications</button>
            <button class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="HamburgerFunction()">&#9776;</button>
        </div>
        
        
        <!-- Hamburger Nav bar!!! -->
        
        <div id="Hamburger" class="w3-row w3-hide-large w3-hide-medium">
        <div class="w3-twothird">
        </div>
        <div class="w3-rest">
            <div class="w3-right w3-bar w3-light-grey w3-round">
                <div class="w3-dropdown-hover">
                <div id="HamburgerButton">
                    <button  class="w3-button">&#9776;</button>
                    <div class="w3-dropdown-content w3-bar-block">
                        <div class="w3-dropdown-content w3-bar-block">
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Introduction')">Introduction</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('PEAProject')">PEA Project</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('AppliedExperience')">Applied Experience</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Process')">Process</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('TeamEnvironment')">Team Environment</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('ProjectManagement')">Project Management</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Requirements')">Requirements</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Analysis')">Analysis</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Design')">Design</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Implementation')">Implementation</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Test')">Test</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Deployment')">Deployment</button>
                        <button class="w3-bar-item w3-button" onclick="ChangeContent('Training')">Training</button>
                        <button class="w3-bar-item w3-button w3-left-align" onclick="ChangeContent('Maintenance')">Maintenance</button>
                        <button class="w3-bar-item w3-button w3-left-align" onclick="ChangeContent('Communications')">Communications</button>
                    </div>
                    </div>
                </div>
            
        </div>    
        </div>
    </div>
`;
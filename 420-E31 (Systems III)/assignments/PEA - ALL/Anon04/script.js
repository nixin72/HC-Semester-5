// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp', ['ngRoute']);

// configure our routes
scotchApp.config(function ($routeProvider) {
	$routeProvider

		// route for the home page
		.when('/', {
			templateUrl: 'pages/home.html',
			controller: 'mainController'
		})

		// route for the about page
		.when('/Process', {
			templateUrl: 'pages/Initiation/process.html',
			controller: 'processController'
		})

		// route for the contact page
		.when('/TeamEnvironment', {
			templateUrl: 'pages/Initiation/team_environment.html',
			controller: 'teamEnvironmentController'
		})
		.when('/ProjectManagement', {
			templateUrl: 'pages/Initiation/project_management.html',
			controller: 'projectManagementController'
		})
		.when('/Requirements', {
			templateUrl: 'pages/Construction/requirements.html',
			controller: 'requirementsController'
		}
		).when('/Analysis', {
			templateUrl: 'pages/Construction/analysis.html',
			controller: 'analysisController'
		})
		.when('/Design', {
			templateUrl: 'pages/Construction/design.html',
			controller: 'designController'
		})
		.when('/Implementation', {
			templateUrl: 'pages/Construction/implementation.html',
			controller: 'implementationController'
		})
		.when('/Test', {
			templateUrl: 'pages/Construction/test.html',
			controller: 'testController'
		})
		.when('/Training', {
			templateUrl: 'pages/Release/training.html',
			controller: 'trainingController'
		})
		.when('/Deployment', {
			templateUrl: 'pages/Release/deployment.html',
			controller: 'deploymentController'
		})
		.when('/Maintenance', {
			templateUrl: 'pages/maintenance.html',
			controller: 'maintenanceController'
		})
		.when('/Communications', {
			templateUrl: 'pages/communications.html',
			controller: 'communicationsController'
		})
		;
});

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function ($scope) {
	// create a message to display in our view
	$scope.description = 'Co Op Internship report';
	$scope.title = 'CO-OP Report';

	//date
	let date = new Date();
	let publishedDate = date.toTimeString();
	$scope.publishedDate = publishedDate;
	$scope.author = "Amirreza Yadollahi";
	$scope.profileUrl = "";
});

scotchApp.controller('aboutController', function ($scope) {
	$scope.message = 'Look! I am an about page.';
});

scotchApp.controller('contactController', function ($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});


/* page controllers  */

scotchApp.controller('processController', function ($scope) {
	$scope.title = 'Process';
});

scotchApp.controller('teamEnvironmentController', function ($scope) {
	$scope.title = 'Team Environment ';
});

scotchApp.controller('projectManagementController', function ($scope) {
	$scope.title = 'Project Management ';

});

scotchApp.controller('requirementsController', function ($scope) {
	$scope.title = 'Requirements ';
});


scotchApp.controller('analysisController', function ($scope) {
	$scope.title = 'Analysis';
});

scotchApp.controller('maintenanceController', function ($scope) {
	$scope.title = 'Maintenance';
});



scotchApp.controller('implementationController', function ($scope) {
	$scope.title = 'Implementation';
});


scotchApp.controller('testController', function ($scope) {
	$scope.title = 'Test';
});

scotchApp.controller('deploymentController', function ($scope) {
	$scope.title = 'Deployment';
});
scotchApp.controller('trainingController', function ($scope) {
	$scope.title = 'Training';
});
scotchApp.controller('designController', function ($scope) {
	$scope.title = 'Design';
});

scotchApp.controller('communicationController', function ($scope) {
	$scope.title = 'Communication';
});
const para = document.getElementById('mainContainer').getElementsByTagName('p');
let prevHash = '';

document.addEventListener('DOMContentLoaded', () => {
    /* Gets the hamburger, and shows/hides the nav on click. */
    const navBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

    if (navBurgers.length != 0) {
        navBurgers.forEach((el) => {
            el.addEventListener('click', () => {
                const target = el.dataset.target;
                const targetElement = document.getElementById(target);

                el.classList.toggle('is-active');
                targetElement.classList.toggle('is-active');
            });
        });
    }
});

document.addEventListener('scroll', () => {
    /* Shows/hides the jump button based on page position. */
    const jumpBtn = document.querySelector('#jumpButton');

    if (window.scrollY > 200) {
        jumpBtn.classList.add('show');
        jumpBtn.classList.remove('hide');
    } else {
        jumpBtn.classList.add('hide');
        jumpBtn.classList.remove('show');
    }
});

document.querySelector('#jumpButton').addEventListener('click', () => {
    /* Jump button functionality. */
    document.body.scrollTop = document.documentElement.scrollTop = 0;
});

const hideAllExcept = (id) => {
    /* Add the hidden class to all memebers of para except for the one specified
       in the parameter. */
    // Create an iterator for the HTMLCollection collection type. Needed for
    // the latter `for x of y` loop.
    HTMLCollection.prototype[Symbol.iterator] = Array.
        prototype[Symbol.iterator];

    for (let el of para) {
        if(el.id === id) {
            el.classList.remove('hidden');
        } else {
            el.classList.add('hidden');
        }
    }
};

const setTitleSubtitle = (title, subtitle) => {
    /* Sets the Hero sections tilte and subtitle to those passed in. */
    const t = document.getElementById('hTitle');
    const s = document.getElementById('sTitle');

    t.innerText = title;
    s.innerText = subtitle;
};

setInterval(() => {
    // I blame Richard Chan for having to make this switch statement.
    if (prevHash !== location.hash) {
        switch (location.hash) {
        case '#home':
            hideAllExcept('home');
            setTitleSubtitle('Home', 'Fun Subtitle!');
            break;
        case '#process':
            hideAllExcept('process');
            setTitleSubtitle('Process', 'Fun Subtitle!');
            break;
        case '#teamEnvironment':
            hideAllExcept('teamEnvironment');
            setTitleSubtitle('Team Environment', 'Fun Subtitle!');
            break;
        case '#projectManagement':
            hideAllExcept('projectManagement');
            setTitleSubtitle('Project Management', 'Fun Subtitle!');
            break;
        case '#requirements':
            hideAllExcept('requirements');
            setTitleSubtitle('Requirements', 'Fun Subtitle!');
            break;
        case '#analysis':
            hideAllExcept('analysis');
            setTitleSubtitle('Analysis', 'Fun Subtitle!');
            break;
        case '#design':
            hideAllExcept('design') ;
            setTitleSubtitle('Design', 'Fun Subtitle!');
            break;
        case '#implementation':
            hideAllExcept('implementation');
            setTitleSubtitle('Implementation', 'Fun Subtitle!');
            break;
        case '#test':
            hideAllExcept('test');
            setTitleSubtitle('Test', 'Fun Subtitle!');
            break;
        case '#deployment':
            hideAllExcept('deployment');
            setTitleSubtitle('Deployment', 'Fun Subtitle!');
            break;
        case '#training':
            hideAllExcept('training');
            setTitleSubtitle('Training', 'Fun Subtitle!');
            break;
        case '#maintenance':
            hideAllExcept('maintenance');
            setTitleSubtitle('Maintenance', 'Fun Subtitle!');
            break;
        case '#communications':
            hideAllExcept('communications');
            setTitleSubtitle('Communications', 'Fun Subtitle!');
            break;
        default:
            hideAllExcept('404');
            setTitleSubtitle('404 - Page Not Found!', 'Oh no!');
        }

        prevHash = location.hash;
    }
}, 5);

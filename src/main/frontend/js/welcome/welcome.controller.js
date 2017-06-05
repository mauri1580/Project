/*@ngInject*/
export default class WelcomeController {
    constructor($state, $timeout) {
        let welcome = this;

        welcome.$state = $state;
        welcome.$timeout = $timeout;

        welcome.features = require('../../assets/json/features.json');
        welcome.visibleFeature = [];
        welcome.visibleFeature.push(welcome.features[0]);
        welcome.visibleFeatureIndex = 0;
        welcome.continueLoop = true;

        welcome.$timeout(() => welcome.loopThroughFeatures(), 7000);
    }

    setVisibleIndex(i) {
        let welcome = this;

        welcome.transitionBetweenFeatures(i);
        welcome.continueLoop = false;
    }

    loopThroughFeatures() {
        let welcome = this;

        if (welcome.continueLoop === false) return;

        //If we're at the end then restart, else continue counting up
        if (welcome.visibleFeatureIndex >= welcome.features.length - 1) {
            welcome.visibleFeatureIndex = 0;
            welcome.transitionBetweenFeatures(welcome.visibleFeatureIndex);
        } else {
            welcome.transitionBetweenFeatures(++welcome.visibleFeatureIndex);
        }

        welcome.$timeout(() => welcome.loopThroughFeatures(), 2500);
    }

    // ngAnimate attaches to ng-repeat and we animate on the events associated with it.
    transitionBetweenFeatures(i) {
        let welcome = this;

        welcome.visibleFeature = [];
        welcome.visibleFeatureIndex = i;
        welcome.visibleFeature.push(welcome.features[i]);
    }
}

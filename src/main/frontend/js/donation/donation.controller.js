/*@ngInject*/
export default class DonationController {
    constructor($state, AuthService, DonationService) {
        this.$state = $state;
        this.AuthService = AuthService;
        this.DonationService = DonationService;
        this.user = {};
        this.active = false;
        this.currentClass = 'donation-card';
    }

    $onInit() {
        this.retrieve();
        this.reset();
    }

    retrieve() {
        this.AuthService.getUser()
            .then((result) => {
                this.user = result;
            });
    }

    startAdd() {
        this.add = true;
        this.active = true;
        this.currentClass = 'donation-card-add';
    }

    startSearch() {
        this.search = true;
        this.hasSearchResult = false;
        this.active = true;
        this.currentClass = 'donation-card-search';
    }

    startNotify() {
        this.DonationService.notifyDonors();
    }

    reset() {
        this.active = this.add = this.search = this.hasSearchResult = this.notify = false;
        this.currentClass = 'donation-card';
        this.formData = {};
    }

    submitNewDonor() {
        let newDate = [];

        newDate[0] = this.dateOfBirth.getFullYear();
        newDate[1] = this.dateOfBirth.getMonth() + 1;
        newDate[2] = this.dateOfBirth.getDate();

        this.formData.dateOfBirth = newDate;

        this.DonationService.addNewDonor(this.formData).then((result) => this.reset());
    }

    searchDonors() {
        this.DonationService.searchForDonor(this.formData)
            .then((result) => {
                this.hasSearchResult = true;
                this.searchResults = result.data;
                console.log(result);
        });
    }

    submitDonation(donorId) {
        this.DonationService.submitDonation(donorId)
            .then((result) => {
                this.reset();
            });
    }


}

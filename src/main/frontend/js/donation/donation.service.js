/*@ngInject*/
export default class Donation {
    constructor($http, $q) {
        this.$http = $http;
        this.$q = $q;
    }


    addNewDonor(donor) {
        return this.$http({
            method: 'POST',
            url: "/api/donor/add",
            data: donor
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        );
    }

    searchForDonor(names) {
        let params = {
            firstName: names.firstName,
            lastName: names.lastName
        }

        return this.$http({
            method: 'GET',
            url: '/api/donor/search/name',
            params: params
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        )
    }

    submitDonation(donorId) {
        let donor = {donorId: donorId};

        return this.$http({
            method: 'GET',
            url: "/api/donation/add",
            params: donor
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        );
    }

    notifyDonors() {
        return this.$http({
            method: 'GET',
            url: "/api/donor/notify"
        }).then(
            (response) => {
                return response;
            },
            (response) => {
                return response;
            }
        );
    }

}

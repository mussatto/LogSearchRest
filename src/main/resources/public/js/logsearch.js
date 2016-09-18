var vm;
window.onload = function() {
	vm = new Vue({
		el : '#logSearchDiv',
		data : {
			hostName : 'http://localhost:8080',
			searchQuery : '',
			newTrigger : "",
			logLines : [],
			alerts : [],
			triggers : []
		},
		methods : {

			search : function() {
				url = this.hostName + '/search?query=' + this.searchQuery;
				this.getJson(url, 'logLines');
			},
			getRefreshAlerts : function() {
				url = this.hostName + '/refreshAlerts';
				this.getJson(url, null);
			},
			getAlerts : function() {
				url = this.hostName + '/getAlerts';
				this.getJson(url, 'alerts');
			},
			createTrigger : function() {
				url = this.hostName + '/createTrigger';
				data = {
					query : this.newTrigger
				};
				this.postJson(url, data);

				this.getAllTriggers();
			},
			getAllTriggers : function() {
				url = this.hostName + '/getAllTriggers';
				this.getJson(url, 'triggers');
			},
			postJson : function(url, sendData) {
				this.$http.post(url, sendData).then(function(response) {
					console.log("reponse:" + response);
				}, function(data) {
					console.log('error ' + data);
				});
			},
			getJson : function(url, setData) {
				this.$http.get(url).then(function(response) {

					responseJson = response.json();
					if (typeof response !== 'undefined' && response != null) {
						if (typeof setData !== 'undefined' && setData != null)
							this.$set(setData, response.body);
					}

					console.log('search success!');
				}, function(data) {
					console.log('error ' + data);
				});
			}

		},
		ready : function() {
			this.getAlerts();
			this.getAllTriggers();

			setInterval(function() {
				this.getAlerts();
				this.getAllTriggers();
			}.bind(this), 5000);
		}

	})
}
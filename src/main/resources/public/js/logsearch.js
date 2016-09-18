var vm
window.onload = function () {
    vm = new Vue({
      el: '#logSearchDiv',
      data: {
        hostName: 'http://localhost:8080',
        searchQuery:'',
        logLines: [],
        alerts:[],
        triggers:[]
      },
      methods: {

        search: function () {
            url = this.hostName+'/search?query='+this.searchQuery;
            this.getJson(url, 'logLines');
        },
        getAlerts: function () {
            url = this.hostName+'/getAlerts'
            this.getJson(url, 'alerts');
        },
        getAllTriggers: function () {
            url = this.hostName+'/getAllTriggers'
            this.getJson(url,'triggers');
        },
          
        getJson: function(url, setData){
            this.$http.get(url).then(function(response){
                
            	responseJson = response.json();
                if( typeof responseJson !== 'undefined' && responseJson != null){
                    this.$set(setData, response.body);
                }

                console.log('search success!');
            },
            function(data){
            	console.log('error '+data);
            });
        }

      }

    })
}
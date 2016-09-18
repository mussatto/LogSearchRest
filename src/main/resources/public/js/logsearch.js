var vm;
window.onload = function () {
    vm = new Vue({
      el: '#logSearchDiv',
      data: {
        hostName: 'http://localhost:8080',
        searchQuery:'',
        newTrigger:"",
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
            url = this.hostName+'/getAlerts';
            this.getJson(url, 'alerts');
        },
        createTrigger: function(){
            url = this.hostName+'/createTrigger';
            data = {query:this.newTrigger};
            this.postJson(url, data);
        },
        getAllTriggers: function () {
            url = this.hostName+'/getAllTriggers';
            this.getJson(url,'triggers');
        },
        postJson: function(url, sendData){
            this.$http.post(url, JSON.stringify(sendData)).then(function(response){
                console.log("reponse:"+response);
            },
            function(data){
            	console.log('error '+data);
            });
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
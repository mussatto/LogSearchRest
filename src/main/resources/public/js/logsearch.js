var vm
window.onload = function () {
    vm = new Vue({
      el: '#logSearchDiv',
      data: {
        hostName: 'http://localhost:8080',
        searchQuery:'',
        logLines: []
      },
      methods: {

        search: function () {
            url = this.hostName+'/search?query='+this.searchQuery;
            this.$http.get(url).then(function(response){
                
            	lines = response.json();
                if( typeof lines !== 'undefined' && lines != null){
                    this.$set('logLines', response.body);
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
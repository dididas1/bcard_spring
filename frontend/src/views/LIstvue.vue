<template>
    <div id="Listvue">
        <div class="container">
            <div class="form-group">
             <table>
                <tbody>
                  <tr v-for="(data, length) in datas" :key="length">
                      <td><router-link :to="{ name: 'BoardDetail', params: { boardNo: data.bNo }}">{{data.bNo}}</router-link></td>
                      <td>{{data.id}}</td>
                      <td>{{data.bTitle}}</td>
                  </tr>
                </tbody>
              </table>
            </div>
        </div>
    </div>
</template>

<script>

export default {
  name: 'Listvue',
  data () {
    return {
      datas: [],
      bNo: '',
      id: '',
      bTitle: '',
      result: null
    }
  },
  methods: {
  },
  created: function () {
    this.$http.get('/listObj')
      .then(res => {
        this.datas = res.data.result
        console.log(this.datas)
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

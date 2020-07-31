<template>
    <div id="Listvue">
        <div class="container">
            <div class="form-group">
              <input type="text" v-model="bno"/>
              <input type="text" v-model="bTitle" placeholder="이름을 입력합니다"/>
              <button v-on:click="addContact">수정</button>
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
    fetchContacts: function () {
    },
    addContact: function () {
      this.$http.post('/baordCreate',
        { bno: this.id, bTitle: this.bTitle }
      ).then(response => {
        console.warn(response)
        this.result = response.data
        this.$router.push('/list')
      }).catch((ex) => {
        console.warn('ERROR!!!!! : ', ex)
      })
    }
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

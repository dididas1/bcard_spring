<template>
    <div id="Listvue">
        <div class="container">
            <div class="form-group">
              <input type="text" v-model="id"/>
              <input type="text" v-model="bTitle" placeholder="이름을 입력합니다"/>
              <button v-on:click="addContact">수정</button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'detail',
  data () {
    return {
      datas: [],
      bNo: '',
      id: '',
      bTitle: '',
      result: null
    }
  },
  computed: {
    boardNo () {
      return this.$route.bNo
    }
  },
  methods: {
    fetchContacts: function () {
    }
  },
  created: function () {
    axios.get('http://localhost:8080/list')
      .then(res => {
        this.datas = res.data.result
        this.$router.params('등록됨')
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

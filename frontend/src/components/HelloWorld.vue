<template>
  <div>
      <h1>Ola spring ? {{msg}}</h1>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  data (){
    return {
      msg : ''
    }
  },
  mounted () {

    fetch("/ambiente/hello").then((response)=>response.text()).then((data)=>{
        this.msg = data;
    })
      
  }
}
</script>

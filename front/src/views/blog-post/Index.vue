
<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'BlogPost',

    metaInfo: { title: 'BlogPost' },

    extends: View,

    mixins: [
      LoadSections([
        'BlogPost',
      ]),
    ],

    props: {
      id: {
        type: String,
        default: 'contact',
      },
    },
  }
</script>

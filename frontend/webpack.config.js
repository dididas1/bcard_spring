import GoogleFontsPlugin from 'google-fonts-webpack-plugin'

export default {
  'entry': 'index.js',
  /* ... */
  plugins: [
    new GoogleFontsPlugin({
      fonts: [
        { family: 'Source Sans Pro' },
        { family: 'Roboto', variants: [ '400', '700italic' ] }
      ]
      /* ...options */
    })
  ]
}

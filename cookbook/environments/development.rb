name 'development'
description 'development with vagrant'
override_attributes ({
    'stack' => {
        'app' => {
            'dir' => '/host/source/stack-app-static/app/'
        }
    },
    # Vagrant doesn't work properly with sendfile linked to shared directory
    # http://jeremyfelt.com/code/2013/01/08/clear-nginx-cache-in-vagrant/
    'nginx' => {
      'sendfile' => 'off'
    }
})
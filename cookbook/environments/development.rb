name 'development'
description 'development with vagrant'
override_attributes ({
    'stack' => {
        'app' => {
            'dir' => '/host/source/stack-app-static/app/'
        }
    },
    # Vagrant doesn't work properly with sendfile linked to shared directory
    # https://docs.vagrantup.com/v2/synced-folders/virtualbox.html
    # https://www.virtualbox.org/ticket/9069
    'nginx' => {
      'sendfile' => 'off'
    }
})